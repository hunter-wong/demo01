<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24 0024
  Time: 上午 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="../js/jquery1.42.min.js"></script>
    <script src="../js/echarts.min.js"></script>
</head>
<body>
    <div id="main" style="width: 600px; height: 400px;"></div>
    <script>
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            //图表标题
            title : {
                text : 'ECharts柱状图'
            },
//提示信息
            tooltip : {
                trigger : 'axis',//显示该列下所有坐标轴所对应的数据
                axisPointer : { // 坐标轴指示器,坐标轴触发有效
//鼠标滑过显示效果 'line'直线 | 'shadow'阴影(默认)
                    type : 'shadow'
                }
            },
            //X轴数据
            xAxis : {
                data : []
            },
            yAxis : {},
            //系列列表
            series : [ {
                name : '访问量',//鼠标滑过数字前面的内容,“访问量：450”
                type : 'bar',//柱状图类型
//样式定制,可以自定义字体颜色,大小等属性,本例中使用默认样式
                label : {
                    normal : {
                        show : true
                    }
                },
                data : [] //每一列的数据
            } ]
        };

        //使用制定的配置项和数据显示图表(装载)
        myChart.setOption(option);
        //下载动画
        myChart.showLoading();

        $.ajax({
            url:"bar.action",
            type:"get",
            dataType:"json",
            success:function (data) {
                var x = [];
                var y = [];
                for(var i = 0 ; i<data.length;i++){
                    var j = data[i];
                    x.push(j.name);
                    y.push(j.value)
                }
                myChart.hideLoading();
                myChart.setOption({
                    xAxis : {
                        data : x
                    },
                    series : [ {
                        // 根据名字对应到相应的系列
                        name : '数量',
                        data : y
                    } ]
                });
            },
            error:function () {
                alert('加载数据失败')
            }
        });

    </script>
</body>
</html>
