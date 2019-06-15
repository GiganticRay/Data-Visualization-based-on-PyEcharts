<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="main" style="width: 1300px;height:700px;">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/esl.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">

var myChart = echarts.init(document.getElementById('main'));
myChart.showLoading();
var app = {};
option = null;
var posList = [
    'left', 'right', 'top', 'bottom',
    'inside',
    'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
    'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
];

app.configParameters = {
    rotate: {
        min: -90,
        max: 90
    },
    align: {
        options: {
            left: 'left',
            center: 'center',
            right: 'right'
        }
    },
    verticalAlign: {
        options: {
            top: 'top',
            middle: 'middle',
            bottom: 'bottom'
        }
    },
    position: {
        options: echarts.util.reduce(posList, function (map, pos) {
            map[pos] = pos;
            return map;
        }, {})
    },
    distance: {
        min: 0,
        max: 100
    }
};

app.config = {
    rotate: 90,
    align: 'left',
    verticalAlign: 'middle',
    position: 'insideBottom',
    distance: 15,
    onChange: function () {
        var labelOption = {
            normal: {
                rotate: app.config.rotate,
                align: app.config.align,
                verticalAlign: app.config.verticalAlign,
                position: app.config.position,
                distance: app.config.distance
            }
        };
        myChart.setOption({
            series: [{
                label: labelOption
            }, {
                label: labelOption
            }, {
                label: labelOption
            }, {
                label: labelOption
            }]
        });
    }
};


var labelOption = {
    normal: {
        show: true,
        position: app.config.position,
        distance: app.config.distance,
        align: app.config.align,
        verticalAlign: app.config.verticalAlign,
        rotate: app.config.rotate,
        formatter: '{c}  {name|{a}}',
        fontSize: 16,
        rich: {
            name: {
                textBorderColor: '#fff'
            }
        }
    }
};

option = {
    color: ['#003366', '#006699', '#4cabce', '#e5323e','#0a66d9','#00e69d','#0ffaa9','#0c619a','#8c6a9a'],
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: []
    },
    toolbox: {
        show: true,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            axisTick: {show: false},
            data: ["201407", "201408", "201409", "201410", "201411", "201412", "201501", "201502", "201503", "201504", "201505", "201506"]
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: []
};;

jQuery.ajax({  
	url:'${pageContext.servletContext.contextPath }/1.action',
	contentType:'application/json;charset=utf-8',
	datatype:'json',
    success:function(jsons){  
        var Item = function(){  
            return {  
                name:'',  
                type:'bar',  
                itemStyle: {normal: {areaStyle: {type: 'bar'}}},  
                        label: {normal: {position: 'top'}},  
                        markLine: {data: [{type: 'average', name: '总值'}]},  
                        data:[]  
            }  
        };// series中的每一项为一个item,所有的属性均可以在此处定义  
        var legends = [];// 准备存放图例数据  
        var Series = []; // 准备存放图表数据  
        var json = jsons.data;// 后台返回的json  
        for(var i=0;i < json.length;i++){  
            var it = new Item();  
            it.name = json[i].name;// 先将每一项填充数据  
            legends.push(json[i].name);// 将每一项的图例名称也放到图例的数组中  
            it.data = json[i].data;  
            Series.push(it);// 将item放在series中  
        }  
        
        
        option.xAxis.data= jsons.xContent;// 这一步是设置X轴数据了，需要注意：option.xAxis.data = json.xcontent这样不行  
                              // 折线图可设置上下两个X轴，所以必须是option.xAxis[0].data = json.xcontent  
        option.legend.data = legends;// 设置图例  
        option.series = Series; // 设置图表  
        myChart.hideLoading();
        myChart.setOption(option);// 重新加载图表  
                       },  
                       error:function(){  
                              alert("数据加载失败！请检查数据链接是否正确");  
                       }  
                               
              });  
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
</script>
</div>
</body>
</html>