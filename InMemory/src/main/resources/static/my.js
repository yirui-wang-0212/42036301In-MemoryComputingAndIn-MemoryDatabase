var app = angular.module('myApp', []);
app.controller('myCtrl', function($rootScope,$scope,$http) {

    // 请求数据并更新图标
    $http({
        method: 'GET',
        url: '/getChartData'
    }).then(function successCallback(response) {

        // response.data 为后端返回的 JSON 数据

        // 画图部分
        var chart= new Highcharts.Chart('container', {
            chart: {
                backgroundColor:""
            },
            title: {
                text: '城市平均气温'                //指定图表标题
            },
            xAxis: {
                categories: response.data.xdatas//指定x轴分组
            },
            subtitle:{
                text: 'Source: runoob.com'
            },
            yAxis: {
                title: {
                    text: 'Temperature (\xB0C)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            legend:{
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            tooltip:{
                valueSuffix: '\xB0C'
            },
            series: [{
                name: 'Tokyo',
                data: response.data.ydatas
            },
                {
                    name: 'New York',
                    data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
                        24.1, 20.1, 14.1, 8.6, 2.5]
                },
                {
                    name: 'London',
                    data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0,
                        16.6, 14.2, 10.3, 6.6, 4.8]
                }]
        });

    }, function errorCallback(response) {
        alert("获取图标数据失败")
    });

});