<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${BaseContext}">
    <title>展示视频播放次数图表</title>
    <script src="${pageContext.request.contextPath}/static/js/highcharts.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">

</head>
<body>
<!-- 引入公用的导航信息 -->
<jsp:include page="../header.jsp">
    <jsp:param value="state" name="fromJsp"/>
</jsp:include>
    <%--准备一个highcarts DOM容器 --%>
    <div id="container" style="min-width: 500px;height: 600px" ></div>
    <script>
        /*
            准备highCharts配置项
        */
        var options = {
            //设定图表类型
            chart:{
                type:'column' //柱状图
            },
            title:{
                text:"课程平均播放次数"
            },
            //副标题
            subtitle:{
                text:"数据来源:zhiyou100.com"
            },
            //x轴数据
            xAxis:{
                //x轴水平方向的值 数据应该从后台传输过来 支持EL表达式 ["web前段入门开发","前端开发与git入门"]
                categories:${xData},
                //十字准星线
                crosshair:true
            },
            yAxis: {
                //坐标轴的最小值
                min: 0,
                //y轴的标题
                title: {
                    text: '平均播放次数 (times)'
                }
            },
            tooltip:{
                // head + 每个 point + footer 拼接成完整的 table
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    //point.y:.1f 保留数值后的第一位小数
                    //toFixed(2) 保留两位小数
                    '<td style="padding:0"><b>{point.y}times</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                //是否使用HTMl代码渲染提示框的内容
                useHTML: true
            },
            plotOptions: {
                //column ——>柱状图
                column: {
                    //边框宽度
                    borderWidth: 0
                }
            },
            series: [{
                name: '平均播放次数',
                //水平轴类别名称对应的值动态变化
                data: ${yData}
            }]
        }
        // 第四步： 图表初始化函数 第一个参数是容器的id值 第二个参数是配置信息
        var chart = Highcharts.chart('container', options);
    </script>
</body>
</html>
