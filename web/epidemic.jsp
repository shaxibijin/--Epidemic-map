<%--
  Created by IntelliJ IDEA.
  User: shaxibijin
  Date: 2020/3/5
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>疫情信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
        #body1{
            background-color: #10AEB5;

        }

    </style>
    <!-- bootstrap-->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/js/html5shiv.js"></script> <!--对于IE9的支持-->
    <script src="${pageContext.request.contextPath}/bootstrap/js/respond.js"></script>
</head>
<body id="body1">
    <!--绘制静态界面-->
    <div class="container">
        <!--地图-->
        <div class="row">
            <div class="col-md-12" style="background-color: #fff;margin: 5px;">
                <div id="myMap" style="height: 600px;"></div>
            </div>
        </div>
        <!--表格-->
        <div class="row" style="height: 400px;overflow: auto;">
            <div class="col-md-12" style="background-color: #fff">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>省份</th>
                        <th>确诊人数</th>
                        <th>疑似人数</th>
                        <th>隔离人数</th>
                        <th>治愈人数</th>
                        <th>死亡人数</th>
                    </tr>
                    </thead>
                    <tbody id="tbody1">

                    </tbody>
                </table>
            </div>
        </div>
        <!--柱状图-->
        <div class="row">
            <div class="col-md-12">
                <div id="mycharts" style="height: 500px;background: #fff;">
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>
    <!--绘制动态特效处理-->
    <script type="text/javascript">
        $(function () {
            /**
             * 定义个用来给表格中装在数据的函数
             */
            var fillTotable = function (epidemics) {  //epidemics 集合
                var tbody1 = $("#tbody1");
                tbody1.empty();//先清理数据再使用
                $.each(epidemics,function (index,epidemic) {  //epidemic 数据
                    var tr = $("<tr>"); //tr会加粗的字
                    var td = $("<td>");//td不会加粗的字
                    td.text(epidemic.provinceName);//省份名称 从对应的实体类EpidemicDetailInfo.java中复制
                    tr.append(td);//往行里面添加列

                    td = $("<td>");
                    td.text(epidemic.affirmedTotal);//确诊人数
                    tr.append(td);

                    td = $("<td>");
                    td.text(epidemic.suspectedTotal);//疑似人数
                    tr.append(td);

                    td = $("<td>");
                    td.text(epidemic.isolatedTotal);//隔离人数
                    tr.append(td);

                    td = $("<td>");
                    td.text(epidemic.curedTotal);//治愈人数
                    tr.append(td);

                    td = $("<td>");
                    td.text(epidemic.deadTotal);//死亡人数
                    tr.append(td);

                    tbody1.append(tr);  //在被选元素的结尾（仍然在内部）插入指定内容。

                })
            }
            /**
             * 初始化空白图标
             */
            var myCharts = echarts.init($("#mycharts").get(0));
            var option = {
                title:{
                        text: "当日全国疫情柱状图",
                        subtext:'2020-03-24'
                    },
                    grid:{
                        show:true
                    },
                    legend:{
                        data:["2020-03-24"]
                    },
                    tooltip: {
                        trigger:'axis'
                    },
                    xAxis:{
                        data:[]
                    },
                    yAxis:{
                        data:[]
                    },
                    series:[{
                        type:'bar',
                        name:'2020-03-24',
                        data:[]
                        }]
                };
                myCharts.setOption(option);

            //将服务器端返回的数据设置到图表上
            var fillToChart = function (epidemics) {
                var provinceNames = [];//所有省份名词
                var affirmedTotal = [];//确诊人数
                //遍历数据
                $.each(epidemics,function (index,epidemic) {
                    var obj = [];//将数组存入数组
                    provinceNames.push(epidemic.provinceName);//省份名称
                    affirmedTotal.push(epidemic.affirmedTotal);//确诊人数
                });
                //填充数据
                myCharts.setOption({
                    xAxis: {
                        data: provinceNames
                    },
                    series: [{
                        data: affirmedTotal
                    }]
                });
            };


            /**
             * 定义空白地图
             */
            var myMap = echarts.init($("#myMap").get(0));
            //获取地图json数据，显示中国地图
            $.getJSON("${pageContext.request.contextPath}/echarts/china.json",{},function (chinaJson) {
                echarts.registerMap("china",chinaJson);//注册地图
                var option = {
                    title:{
                        text: "2020-03-24 全国疫情分布图"
                    },
                    legend:{
                        data:["累计确诊人数"]
                    },
                    tooltip:{},
                    visualMap:{
                        type:'piecewise',
                        min:0,
                        max:10000,
                        splitList:
                           [{
                              start:1000,
                              end:10000
                           },{
                              start:500,
                              end:1000
                           },{
                              start:100,
                              end:500
                           },{
                              start:0,
                              end:100
                           }],
                        textStyle:
                            {
                                color:'orange'
                            }
                    },
                    series:[
                        {
                            name:'累计确诊人数',
                            type:'map',
                            mapType:'china',
                            data:[]
                        }
                    ]
                };
                myMap.setOption(option);
            },"json");

            /**
             * 将数据填充到地图中
             */
            var fillToMap = function(epidemics){
                var data = [];//使用数组接收数据
                //遍历数据
                $.each(epidemics,function (index,epidemic) {
                    var obj ={};//将数据存入对象
                    console.info("epidemic------------"+epidemic);
                    obj.name = epidemic.provinceName;//省份名称
                    obj.value = epidemic.affirmedTotal;//确诊人数
                    data.push(obj);
                });
                console.info("data------------"+data);
                //给地图设置参数
                myMap.setOption({
                    series:[
                        {
                            name:'累计确诊人数',
                            type:'map',
                            mapType:'china',
                            data:data //将数据填充进去，不然就是空白地图
                        }
                    ]
                })
            };

            /**
             * 发送请求获取最新疫情数据（用Ajax）
             */

            $.get("${pageContext.request.contextPath}/epidemicData//ajax/lastestData",{},function (resp) { //对应的就是AjaxResponseInfo
                if (resp.code < 0){
                    alert(resp.msg);//弹框提示
                }else {

                    fillTotable(resp.data);//给表格填充数据
                    fillToChart(resp.data);//给柱状图填充数据
                    fillToMap(resp.data);//给地图填充数据
                }
            },"json");

        });
    </script>
</body>
</html>












