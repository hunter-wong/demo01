<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24 0024
  Time: 下午 2:07
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
    <script src="js/jquery1.42.min.js"></script>
    <script src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 600px; height: 400px;"></div>
<script>
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title : {
            text : 'ECharts折线图：新闻数据访问量'
        },
        tooltip : {},
        xAxis : {
            data : []
        },
        yAxis : {},
        series : [ {
            name : '访问量',
            type : 'line',
            data : []
        } ]
    };
    //使用制定的配置项和数据显示图表
    myChart.setOption(option);

    myChart.showLoading();
    $.ajax({
        type:'post',
        url:'line.action',
        dataType:'json',
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
                    name : '访问量',
                    type : 'line',
                    data : y
                } ]
            });
        },
        error:function () {
            alert('加载失败' +
                '')
        }
    });

</script>
</body>
</html>
