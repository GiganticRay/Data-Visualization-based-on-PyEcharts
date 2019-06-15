import pymysql
import requests
import json
import datetime

from pyecharts import options as opts
from pyecharts.charts import Geo, Timeline, Page, Map, Bar, Grid
from pyecharts.globals import ChartType, SymbolType
from pyecharts.commons import utils

import numpy as np
import pandas as pd

global yearMonth  # 在使用前初次声明
yearMonth = []
global municipalLonLat # 每个municipal及其平均经纬度
municipalLonLat = []
global allCountys   # 每个市的名字
allCountys = []
global rowDict # 每个 municipal 12个月的总营销额 ———— dict
rowDict = {}
global rowData # 每个 municipal 12个月的总营销额
rowData = []
global rowBrand # 对应rowData 12个月销售最高的品牌
rowBrand = []

def getnow():
    print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))

# 第四个实验的数据处理
def OrignData4():
    db = OrignDbConn()
    cursor = db.cursor()
    # 1: 的出月份
    cursor.execute("select distinct(yearmonth) from sale")
    data = cursor.fetchall()
    global yearMonth
    for item in data:
        yearMonth.append(int(list(item)[0]))
    yearMonth = sorted(yearMonth)
    yearMonth = [str(i) for i in yearMonth]


    # 2：得出每个市及其对应经纬度
    cursor.execute("select municipal ,avg(substring_index(loc, ',', -1)), avg(substring_index(loc, ',', 1)) from sale group by municipal")
    data = cursor.fetchall()
    global municipalLonLat
    municipalLonLat = data
    # 初始化所有市
    global allCountys
    allCountys = np.array(municipalLonLat)[:, 0]
    # 转化为 json
    jsonCountyLonLat = '{'
    for item in municipalLonLat:
        if item[0] != '':
            jsonCountyLonLat += "\"{}\":[{}, {}],".format(item[0], item[1], item[2])
    jsonCountyLonLat +='$}'
    jsonCountyLonLat = jsonCountyLonLat.replace(",$", "")

    data = cursor.execute("select a.municipal, MAX(a.brandCounts) as maxCount, a.yearmonth, any_value(a.brand_name) from(select municipal as municipal, count(brand_name) as brandCounts, brand_name as brand_name, yearmonth as yearmonth from sale group by municipal, yearmonth, brand_name) a group by a.municipal, a.yearmonth")

    data = cursor.fetchall()
    testa = np.array(data)
    # 2 level dict: rowDict['municipal']['201407']
    global rowDict
    global rowData
    global rowBrand
    for municipal in allCountys:
        tmpdict = {}
        tmpArr = []         # 存放销售额
        tmpBrandArr = []    # 存放销售品牌
        if(municipal != ""):
            tmpArr.append(municipal)
            tmpBrandArr.append(municipal)
            allTurnOver = testa[testa[:, 0] == municipal]      # 提取出该市的十二个月的最高的销售额brand:municipal, turnover, month, brand
            for tmp in allTurnOver:
                tmpdict.update({tmp[2]:tmp[1]})
                tmpArr.append(int(tmp[1]))
                tmpBrandArr.append(tmp[3])

            # 遍历所有月、如果该月没有信息、则添0, 对于brand，添加 ""
            for month in yearMonth:
                if(tmpdict.__contains__(month) != True):
                    tmpdict.update({month: 0})
                    tmpArr.append(0)
                    tmpBrandArr.append("")


            rowDict.update({municipal:tmpdict})                    # 添加该城市的 12 月数值, dict
            rowData.append(tmpArr)                              # 添加该城市的 12 月数值, array
            rowBrand.append(tmpBrandArr)

# make 时间轴地图
def timeline_map() -> Timeline:
    allMaps = []

    # 共有 12 个地图
    for (months, index) in zip(yearMonth, range(0, 12)):

        # 计算得出当前颜色域的范围, 根据个数平均分成10个组。
        sliptNum = int(len(list(np.array(rowData)[:,index+1])) / 10)
        splitBoundaryIndex = [i for i in range(0, len(list(np.array(rowData)[:,index+1])), sliptNum)]
        splitBoundaryIndex.append(len(list(np.array(rowData)[:,index+1])) - 1)   # 以防万一，将最后一个也加进去。
        tmpSort = [int(i) for i in list(np.array(rowData)[:,index+1])]
        tmpSort.sort()
        splitBoundary = [tmpSort[i] for i in splitBoundaryIndex]                 # ex: [1, 4, 9, 16, 33, 54, 125, 201, 317, 538, 2663]
        # 转化为 json
        jsonSplitBoundary = '['
        for i in range(len(splitBoundary) - 1):
            jsonSplitBoundary += "{\"min\": " + str(splitBoundary[i]) + ", \"max\": " + str(splitBoundary[i+1]) + "},"
        jsonSplitBoundary +='$]'
        jsonSplitBoundary = jsonSplitBoundary.replace(",$", "")
        jsonSplitBoundary = json.loads(jsonSplitBoundary)

        map = (
            Geo()
            .add_schema(maptype="四川+重庆")
            .add_coordinate_json(
                json_file='./myjson.json'
            )
            .set_series_opts(label_opts=opts.LabelOpts(is_show=False))
            .set_global_opts(
                title_opts=opts.TitleOpts(title="实验四-每月的销售最高Brand-municipal"),
                # list 转 int, 获取 max range, min default 0
                visualmap_opts=opts.VisualMapOpts(
                        max_= max([int(x) for x in list(np.array(rowData)[:,index+1])]),
                        is_piecewise=True,
                        pieces = jsonSplitBoundary
                    ),

            )
        )
        # 通过地点 name 与 该点的数值 添加地理点
        # 这里通过循环遍历、因为他这个我真的没办法添加品牌。。。，这里用 series_name 来存放 brand
        for z in zip(list(np.array(rowData)[:,0]), list(np.array(rowData)[:,index+1]), list(np.array(rowBrand)[:,index+1])):
            map.add(
                series_name = z[2],
                data_pair = [list(z[0:2])],
                type_=ChartType.EFFECT_SCATTER,
                large_threshold = 2000,
                label_opts = opts.LabelOpts(formatter = utils.JsCode("""
                function (params) {
                    return params.seriesName
                }
                """))
            )
        allMaps.append(map)
    # 将allMaps 与时间轴绑定
    tl = (
        Timeline().add_schema(
            play_interval = 2000,
            is_auto_play = True
        )
    )
    for (itemTime, itemMap) in zip(yearMonth, allMaps):
        tl.add(itemMap, itemTime)

    return tl

# make 时间轴Bar
def timeline_bar() -> Timeline:
    allBars = []
    # 共有 12 个Bar
    for (months, index) in zip(yearMonth, range(0, 11)):
        
        bar = Bar()
        bar.set_global_opts(
                title_opts=opts.TitleOpts("实验二-每月的购买力活跃程度")
            )
        bar.add_xaxis(['municipal'])    
        for z in zip(list(np.array(rowData)[:,0]), list(np.array(rowData)[:,index+1]), list(np.array(rowBrand)[:,index+1])):
            bar.add_yaxis(series_name = z[0] + z[2], yaxis_data = [z[1]]).set_global_opts(
                    title_opts=opts.TitleOpts("实验四-每月的销售最高Brand-city"),
                    legend_opts = opts.LegendOpts(
                            type_ = 'scroll',
                            pos_left = '50%',
                        )
                    )
        allBars.append(bar)

    # 将allBars 与时间轴绑定
    tl = (
        Timeline().add_schema(
            play_interval = 2000,
            is_auto_play = True
        )
    )
    # bug：为什么后面的 bar 的x轴坐标会覆盖掉前面的bar呢
    for (itemTime, itemBar) in zip(yearMonth, allBars):
        tl.add(itemBar, itemTime)
    return tl

# 将 图画对象绘制出 html
def DrawIng():
    page = Page(
        page_title = "coding4.municipal"
    )
    page.add(timeline_map())
    page.add(timeline_bar())
    page.render("4.municipal.html")

def OrignDbConn():
    db = pymysql.connect("localhost","raychard","lcwoaili","engipracdb" )
    return db

if __name__ == "__main__":
    # OperCharts()
    # res = testHttp()
    # OperData()


    OrignData4()
    DrawIng()

    print("good luck")
