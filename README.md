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
# 1. 根据“川渝地区零售商销售数据”中的loc字段，判断所属地区（市、县） #

``` python
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
     
```
### 1.1注意事项： ###
> 注意错误回滚以及设置合适的批量提交数量即可

#  2、不同地区（市、县）每月的购买力活跃程度，可视化方式：地图+时间轴（可拖动时间轴） #
``` python
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
```
### 2.1 注意事项：因为PyEcharts官方数据并未有精确到 county 级别的经纬度信息、所以需要先从数据库读入并导入。再者就是 PyEcharts 没有提供组合地域组合的功能、所以这里需要修改本地 Pyecharts 的地理数据库，才能正常显示 ###
> 还有就是因为数值分配不均的问题，所以要自适应颜色域，关键代码如下
``` python
	# 计算得出当前颜色域的范围, 根据个数平均分成组。
	sliptNum = int(len(list(np.array(rowData)[:,index+1])) / 10)
	splitBoundaryIndex = [i for i in range(0, len(list(np.array(rowData)[:,index+1])), sliptNum)]
	splitBoundaryIndex.append(len(list(np.array(rowData)[:,index+1])) - 1) # 以防万一，将最后一个也加进去。

	tmpSort = [int(i) for i in list(np.array(rowData)[:,index+1])]
	tmpSort.sort()
	splitBoundary = [tmpSort[i] for i in splitBoundaryIndex] # ex: [1, 4, 9, 16, 33, 54, 125, 201, 317, 538, 2663]
```


## 2.2 成果： ##
### 2.县级尺度
![τ=1](https://github.com/GiganticRay/reimagined-dollop/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E4%BA%8C-%E6%AF%8F%E6%9C%88%E7%9A%84%E8%B4%AD%E4%B9%B0%E5%8A%9B%E6%B4%BB%E8%B7%83%E7%A8%8B%E5%BA%A6-%E5%8E%BF.png "实验二-每月的购买力活跃程度-县.png")
### 2.市级尺度
![τ=1](https://github.com/GiganticRay/reimagined-dollop/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E4%BA%8C-%E6%AF%8F%E6%9C%88%E7%9A%84%E8%B4%AD%E4%B9%B0%E5%8A%9B%E6%B4%BB%E8%B7%83%E7%A8%8B%E5%BA%A6-%E5%B8%82.png "实验二-每月的购买力活跃程度-市.png")

# 4）不同地区（市、县）每月销售总量最高的商品品牌(brand)，可视化方式：地图+柱状图+时间轴； #
## 关键代码 ##
``` python
def timeline_map() -> Timeline:
    allMaps = []

    # 共有 12 个地图
    for (months, index) in zip(yearMonth, range(0, 11)):
        map = (
            Geo()
            .add_schema(maptype="四川+重庆")
            .add_coordinate_json(
                json_file='./myjson.json'
            )   
            .set_series_opts(label_opts=opts.LabelOpts(is_show=False))
            .set_global_opts(
                title_opts=opts.TitleOpts(title="实验四-每月的销售最高Brand-county"),
                # list 转 int, 获取 max range, min default 0
                visualmap_opts=opts.VisualMapOpts(
                    max_= max([int(x) for x in list(np.array(rowData)[:,index+1])]),
                    is_piecewise=True,
                    pieces = [
                        {"min": 500},
                        {"min": 400, "max": 500},
                        {"min": 300, "max": 400},
                        {"min": 200, "max": 300},
                        {"min": 150, "max": 200},
                        {"min": 100, "max": 150},
                        {"min": 50, "max": 100},
                        {"min": 0, "max": 50}
                    ]
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
                """)
                )
            )
        allMaps.append(map)
    # 将allMaps 与时间轴绑定
    tl = (
        Timeline()
    )
    for (itemTime, itemMap) in zip(yearMonth, allMaps):
        tl.add(itemMap, itemTime)

    return tl

```
## 注意事项 ###
> 即如何通过自定义 formatter 将商品标签添加上去

## 成果 ##
### 4.县级尺度
![τ=1](https://github.com/GiganticRay/reimagined-dollop/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E5%9B%9B-%E6%AF%8F%E6%9C%88%E7%9A%84%E9%94%80%E5%94%AE%E6%9C%80%E9%AB%98Brand-county.png "实验四-每月的销售最高Brand-county.png")
### 4.市级尺度
![τ=1](https://github.com/GiganticRay/reimagined-dollop/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E5%9B%9B-%E6%AF%8F%E6%9C%88%E7%9A%84%E9%94%80%E5%94%AE%E6%9C%80%E9%AB%98Brand-city.png "实验四-每月的销售最高Brand-city.png")


# 7）不同类型(category)的商品在哪个月达到销售高峰，可视化方式：柱状图/折线图； #
## 关键代码 ##
``` java
	public BrokenLine selectSY7() {
		SaleExample example = new SaleExample();
		List<Sale> sales =  saleMapper.selectSY7(example);
		List<String> dates = new ArrayList<>();
		BrokenLine line = new BrokenLine();
		List<JsonData> jsdt = new ArrayList<>();

		Map<String,List<Integer>> map = new HashMap<>();
		for(Sale s : sales) {
			if(dates.contains(s.getYearmonth())) {
			}else
			{
				dates.add(s.getYearmonth());
			}
			
			if(map.containsKey(s.getCategoryName())) {
				List<Integer> list = map.get(s.getCategoryName());
				list.add(s.getId());
				map.put(s.getCategoryName(), list);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(s.getId());
				map.put(s.getCategoryName(), list);			
			}
		}
		int i = 0;
		String[] xcontent=new String[12];
		for(String date : dates) {
			xcontent[i] = date;
			i++;
		}
		for(String cat : map.keySet()) {
			JsonData jd = new JsonData();
			jd.setName(cat);
			Integer[] datas = new Integer[12];
			int j = 0;
			for(Integer value : map.get(cat)) {
				datas[j] = value;
				j++;
			}
			jd.setData(datas);
			jsdt.add(jd);
		}		
		
		
		line.setxContent(xcontent);
		line.setDatas(jsdt);
		//String jsonOutput = JSON.toJSONString();
		return line;
	}

```
## 注意事项 ###
> 即如何将得到的数据转化前端echarts需要的数据形式，以及动态生成的数据。

## 成果 ##
### 7.柱状图
![τ=1](https://github.com/GiganticRay/Data-Visualization-based-on-PyEcharts/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E4%B8%83-%E6%9F%B1%E7%8A%B6%E5%9B%BE.png)
### 7.折线图
![τ=1](https://github.com/GiganticRay/Data-Visualization-based-on-PyEcharts/blob/master/ShearImg/%E5%AE%9E%E9%AA%8C%E4%B8%83-%E6%8A%98%E7%BA%BF%E5%9B%BE.png)

