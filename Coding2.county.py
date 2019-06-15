import pymysql
import requests
import json
import datetime

from pyecharts import options as opts
from pyecharts.charts import Geo, Timeline, Page, Map, Bar, Grid
from pyecharts.globals import ChartType, SymbolType

import numpy as np

from example.commons import Faker

global yearMonth  #在使用前初次声明
yearMonth = []
global countyLonLat # 每个county及其平均经纬度
countyLonLat = []
global allCountys   # 每个县的名字
allCountys = []
global rowData      # 每个county 12个月的总营销额
rowData = []
global rowDict # 每个 county 12个月的总营销额 ———— dict
rowDict = {}

def getnow():
    print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
 
def OperData():
    db = pymysql.connect("localhost","raychard","lcwoaili","engipracdb" )    # 打开数据库连接
    cursor = db.cursor()                    # 使用 cursor() 方法创建一个游标对象 cursor
    cursor.execute("SELECT distinct(loc) from sale")      # 使用 execute()  方法执行 SQL 查询 
    getnow()
    
    data = cursor.fetchall()                # 使用 fetchone() 方法获取单条数据.
    print("读取成功")
    getnow()

    i = 0
    for tmpData in data:
        lonLat = tmpData[0].split(',')
        res = requests.get("http://api.map.baidu.com/geocoder/v2/?location=" + lonLat[0] + "," + lonLat[1] + "&output=json&pois=0&latest_admin=1&coordtype=wgs84ll&ak=zbLsuDDL4CS2U0M4KezOZZbGUY9iWtVf")  # requests api http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding-abroad
        county = json.loads(res.text)['result']['addressComponent']['district']     # 获取县
        lat = json.loads(res.text)['result']['location']['lat']
        sql = "UPDATE sale SET county = '{}' WHERE loc = '{}'".format(county, tmpData[0])
        i = i + 1
        cursor.execute(sql) # 执行SQL语句

        if(i % 20 == 0):
            try: 
                db.commit()         # 提交到数据库执行
                print("提交成功: {}".format(i))
                getnow()
            except:
                print("出错{}".format(i))
                db.rollback()       # 发生错误时回滚
                getnow()
    
    db.commit()         # 提交到数据库执行
    print("提交成功")
    db.close()                              # 关闭数据库连接

def Func2():
    db = OrignDbConn
    cursor = db.cursor()                    
    cursor.execute("SELECT distinct(loc) from sale")

def OrignData():
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


    # 2：得出每个县及其对应经纬度
    cursor.execute("select county ,avg(substring_index(loc, ',', -1)), avg(substring_index(loc, ',', 1)) from sale group by county")
    data = cursor.fetchall()
    global countyLonLat
    countyLonLat = data
    # 初始化所有县
    global allCountys
    allCountys = np.array(countyLonLat)[:, 0]
    # 转化为 json
    jsonCountyLonLat = '{'
    for item in countyLonLat:
        if item[0] != '':
            jsonCountyLonLat += "\"{}\":[{}, {}],".format(item[0], item[1], item[2])
    jsonCountyLonLat +='$}'
    jsonCountyLonLat = jsonCountyLonLat.replace(",$", "")
    
    # 计算出每个 county 12个月对应的交易次数 format: list [["Amsterdam",101.6,90.1,77.1,69.1]]
    
    data = cursor.execute("select county as county, count(id) as turnover, yearmonth as yearmonth from sale group by county, yearmonth")

    data = cursor.fetchall()
    testa = np.array(data)
    # 2 level dict: rowDict['county']['201407']
    global rowDict
    global rowData
    for county in allCountys:
        tmpdict = {}
        tmpArr = []
        if(county != ""):
            tmpArr.append(county)
            allTurnOver = testa[testa[:, 0] == county]      # 提取出该县的十二个月的销售额:county, turnover, month
            for tmp in allTurnOver:
                tmpdict.update({tmp[2]:tmp[1]})
                tmpArr.append(int(tmp[1]))

            # 遍历所有月、如果该月没有信息、则添0
            for month in yearMonth:
                if(tmpdict.__contains__(month) != True):
                    tmpdict.update({month: 0})
                    tmpArr.append(int(tmp[1]))
            rowDict.update({county:tmpdict})                    # 添加该城市的 12 月数值, dict
            rowData.append(tmpArr)                              # 添加该城市的 12 月数值, array


# make 时间轴地图    
def timeline_map() -> Timeline:
    allMaps = []

    # 共有 12 个地图
    for (months, index) in zip(yearMonth, range(0, 11)):

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
            .add_coordinate_json(               # 读取完之后用 get_coordinate, 这里读入之后，内存中即存放了经纬度与对应名字，所以可以直接用了
                json_file='./myjson.json'
            )   
            .set_series_opts(label_opts=opts.LabelOpts(is_show=False))
            .set_global_opts(
                title_opts=opts.TitleOpts(title="实验二-每月的购买力活跃程度-县"),
                visualmap_opts=opts.VisualMapOpts(
                    max_= max([int(x) for x in list(np.array(rowData)[:,index+1])]), 
                    is_piecewise=True,
                    pieces = jsonSplitBoundary
                ),
            )
        )
        # 通过地点 name 与 该点的数值 添加地理点
        map.add(
            "购买力",
            [list(z) for z in zip(list(np.array(rowData)[:,0]), list(np.array(rowData)[:,index+1]))],
            type_=ChartType.EFFECT_SCATTER,
            large_threshold=2000,
            label_opts=""
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
    # 共有 12 个
    for (months, index) in zip(yearMonth, range(0, 11)):
        bar = (
            Bar()
            .add_xaxis(list(np.array(rowData)[:,0]))
            .add_yaxis("活跃度", list(np.array(rowData)[:,index+1]))
            .set_global_opts(
                title_opts = opts.TitleOpts("实验二-每月的购买力活跃程度-县"),
                datazoom_opts = [opts.DataZoomOpts(), opts.DataZoomOpts(type_="inside")]
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
    for (itemTime, itemBar) in zip(yearMonth, allBars):
        tl.add(itemBar, itemTime) 
    return tl

# 将 图画对象绘制出 html
def DrawIng():
    page = Page(
        page_title = "coding2.county"
    )
    page
    page.add(timeline_map())
    page.add(timeline_bar())
    page.render("2.county.html")

def OrignDbConn():
    db = pymysql.connect("localhost","raychard","lcwoaili","engipracdb" )
    return db

if __name__ == "__main__": 
    # OperCharts()
    # res = testHttp()
    # OperData()

    OrignData()
    DrawIng()

    print("good luck")
