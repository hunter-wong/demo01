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
            text : 'ECharts饼状图：新闻数据访问量'
        },
        series : [ {
            name : '访问量',
            type : 'pie',
            itemStyle : {
                normal : {
                    label : {
                        show : true,
//格式器
                        formatter : '{b} : {c} ({d}%)'
                    },
                    labelLine : {
                        show : true
                    }
                }
            },
            //设定图表的缩放比例
            radius : '60%',
//data中使用name代表圆饼中各小块的名称,value为对应的数值
            data : []
        } ]
    };
    myChart.setOption(option);
    myChart.showLoading();

    $.ajax({
        url:"pie.action",
        type:"get",
        dataType:"json",
        success:function(data){
            myChart.hideLoading();
            myChart.setOption({
                series : [ {
                    data : data
                } ]
            })
        },
        error:function () {
            alert("加载失败")
        }
    });

</script>
</body>
</html>
