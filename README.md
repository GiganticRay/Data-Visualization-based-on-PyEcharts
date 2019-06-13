# reimagined-dollop
# **基于PyEcharts的数据可视化展示**

## **项目综括**
>该项目数据数为涵盖200万条商品购买记录的数据，包括了

>a)	YEARMONTH：销售年月

>b)	STORE_NAME：商店名称
>c)	LOCAL_CHANNEL_TYPE：本地分销渠道名称

>d)	LOCAL_STORE_TYPE：商店类型

>e)	GOLDEN_STORE_FLAG：商店标识

>f)	PROVINCE：省

>g)	CITY：市

>h)	TOWN：县/乡/镇/街道名

>i)	CITY_LEVEL

>j)	ITEM_CODE：商品编号

>k)	PRODUCT_CHINESE_NAME：商品名称

>l)	CATEGORY_NAME：商品类型名

>m)	BRAND_NAME：商品品牌

>n)	TIER_NAME

>o)	VARIANT_NAME：商品所属系列名（了解一下）

>p)	LOC：纬度+ “,” +经度

>目标1）	根据“川渝地区零售商销售数据”中的loc字段，判断所属地区（市、县）

>目标2）	不同地区（市、县）每月的购买力活跃程度，可视化方式：地图+时间轴（可拖动时间轴）；

>目标4）	不同地区（市、县）每月销售总量最高的商品品牌(brand)，可视化方式：地图+柱状图+时间轴；

## **实现**
**1. 根据“川渝地区零售商销售数据”中的loc字段，判断所属地区（市、县）**
''' python
    # python 数据库连接操作
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
        municipal = json.loads(res.text)['result']['addressComponent']['district']     # 获取市
        lat = json.loads(res.text)['result']['location']['lat']
        sql = "UPDATE sale SET municipal = '{}' WHERE loc = '{}'".format(municipal, tmpData[0])
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
    
    # 数据处理重点代码
    for municipal in allCountys:
        tmpdict = {}
        tmpArr = []
        if(municipal != ""):
            tmpArr.append(municipal)
            allTurnOver = testa[testa[:, 0] == municipal]      # 提取出该市的十二个月的销售额:municipal, turnover, month
            for tmp in allTurnOver:
                tmpdict.update({tmp[2]:tmp[1]})
                tmpArr.append(int(tmp[1]))

            # 遍历所有月、如果该月没有信息、则添0
            for month in yearMonth:
                if(tmpdict.__contains__(month) != True):
                    tmpdict.update({month: 0})
                    tmpArr.append(int(tmp[1]))
            rowDict.update({municipal:tmpdict})                    # 添加该城市的 12 月数值, dict
            rowData.append(tmpArr)                              # 添加该城市的 12 月数值, array
    
    
    def timeline_map() -> Timeline:
    allMaps = []

    # 共有 12 个地图
    for (months, index) in zip(yearMonth, range(0, 11)):
        # 这里自己添加的四川 + 重庆，
        # D:\Anaconda3\Lib\site-packages\echarts_china_cities_pypkg\resources\echarts-china-cities-js\sichuan_chongqing.js
        # D:\Anaconda3\Lib\site-packages\pyecharts\datasets\map_filename.json
        map = (
            Geo()
            .add_schema(maptype="四川+重庆")
            .add_coordinate_json(               # 读取完之后用 get_coordinate, 这里读入之后，内存中即存放了经纬度与对应名字，所以可以直接用了
                json_file='./myjson.json'
            )   
            .set_series_opts(label_opts=opts.LabelOpts(is_show=False))
            .set_global_opts(
                title_opts=opts.TitleOpts(title="实验二-每月的购买力活跃程度"),
                visualmap_opts=opts.VisualMapOpts(max_= max([int(x) for x in list(np.array(rowData)[:,index+1])]), is_piecewise=True),
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
        Timeline()
    )
    for (itemTime, itemMap) in zip(yearMonth, allMaps):
        tl.add(itemMap, itemTime)

    return tl
'''


