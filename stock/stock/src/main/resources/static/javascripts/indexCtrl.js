var app = angular.module('app', [])

app.controller('indexCtrl', function($scope, $http) {


    $scope.splitData = function(rawData) {
        var categoryData = [];
        var values = [];
        var volumes = [];
        for (var i = 0; i < rawData.length; i++) {
            categoryData.push(rawData[i].splice(0, 1)[0]);
            values.push(rawData[i]);
            volumes.push([i, rawData[i][4], rawData[i][0] > rawData[i][1] ? 1 : -1]);
        }

        return {
            categoryData: categoryData,
            values: values,
            volumes: volumes
        };
    };

    $scope.calculateMA = function(dayCount, data) {
        var result = [];
        for (var i = 0, len = data.values.length; i < len; i++) {
            if (i < dayCount) {
                result.push('-');
                continue;
            }
            var sum = 0;
            for (var j = 0; j < dayCount; j++) {
                sum += data.values[i - j][1];
            }
            result.push(+(sum / dayCount).toFixed(3));
        }
        return result;
    };

    $scope.getMA = function (dataCount, data){
        var result = [];
        for (var i = 0, len = data.values.length ; i < len; i++) {
            result.push(data.values[i][dataCount]);
        }
        return result;
    };

    $scope.clear = function () {
        $('.item').removeClass('active');
        $('.tab').removeClass('active');
    };

     $scope.tab = function(id) {
         $scope.clear();
         $('#' + id + '-tab').addClass('active');
         $('#' + id + '-panel').addClass('active');
     };

     $scope.getDataByCode = function () {
        console.log($scope.searchInput);
        $scope.update($scope.searchInput);
        $scope.searchInput = '';
     };


    $scope.update = function (code) {
        $scope.initKline('', 'timeKMain', 'Days', code);
        $scope.initKline('', 'dayKMain', 'Days', code);
        $scope.initKline('', 'weekKMain', 'Days', code);
        $scope.initKline('', 'monthKMain', 'Days', code);
    };

    $scope.initData = function () {

        $scope.upColor = '#00da3c';
        $scope.downColor = '#ec0000';
        $scope.searchInput = "";

        $scope.initKline('00', 'timeKMain', 'Days');
        $scope.initKline('00', 'dayKMain', 'Days');
        $scope.initKline('00', 'weekKMain', 'Days');
        $scope.initKline('00', 'monthKMain', 'Days');
    };

    $scope.initKline = function (defaultCode, initId, type, code) {
        console.log( '/get'+ type + '?code=' + (code === undefined ? defaultCode : code));
        $http({
            method: 'GET',
            url: '/get'+ type + '?code=' + (code === undefined ? defaultCode : code)
            //data: {"code": code === undefined ? defaultCode : code}
        }).then(function successCallback(response) {
            var flag = response.data.flag;
            var rawData = response.data.Data;
            var myChart = echarts.init(document.getElementById(initId));
            if(flag) {
                console.log(rawData);
                var data = $scope.splitData(rawData);
                console.log(data);
                myChart.setOption(option = {
                    backgroundColor: '#fff',
                    animation: false,
                    legend: {
                        bottom: 10,
                        left: 'center',
                        data: ['Dow-Jones index', 'MA5', 'MA10', 'MA20']
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross'
                        },
                        backgroundColor: 'rgba(245, 245, 245, 0.8)',
                        borderWidth: 1,
                        borderColor: '#ccc',
                        padding: 10,
                        textStyle: {
                            color: '#000'
                        },
                        position: function (pos, params, el, elRect, size) {
                            var obj = {top: 10};
                            obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 30;
                            return obj;
                        }
                        // extraCssText: 'width: 170px'
                    },
                    axisPointer: {
                        link: {xAxisIndex: 'all'},
                        label: {
                            backgroundColor: '#777'
                        }
                    },
                    toolbox: {
                        feature: {
                            dataZoom: {
                                yAxisIndex: false
                            },
                            brush: {
                                type: ['lineX', 'clear']
                            }
                        }
                    },
                    brush: {
                        xAxisIndex: 'all',
                        brushLink: 'all',
                        outOfBrush: {
                            colorAlpha: 0.1
                        }
                    },
                    visualMap: {
                        show: false,
                        seriesIndex: 4,
                        dimension: 2,
                        pieces: [{
                            value: 1,
                            color: $scope.downColor
                        }, {
                            value: -1,
                            color: $scope.upColor
                        }]
                    },
                    grid: [
                        {
                            left: '10%',
                            right: '8%',
                            height: '50%'
                        },
                        {
                            left: '10%',
                            right: '8%',
                            top: '63%',
                            height: '16%'
                        }
                    ],
                    xAxis: [
                        {
                            type: 'category',
                            data: data.categoryData,
                            scale: true,
                            boundaryGap: false,
                            axisLine: {onZero: false},
                            splitLine: {show: false},
                            splitNumber: 20,
                            min: 'dataMin',
                            max: 'dataMax',
                            axisPointer: {
                                z: 100
                            }
                        },
                        {
                            type: 'category',
                            gridIndex: 1,
                            data: data.categoryData,
                            scale: true,
                            boundaryGap: false,
                            axisLine: {onZero: false},
                            axisTick: {show: false},
                            splitLine: {show: false},
                            axisLabel: {show: false},
                            splitNumber: 20,
                            min: 'dataMin',
                            max: 'dataMax'
                        }
                    ],
                    yAxis: [
                        {
                            scale: true,
                            splitArea: {
                                show: true
                            }
                        },
                        {
                            scale: true,
                            gridIndex: 1,
                            splitNumber: 2,
                            axisLabel: {show: false},
                            axisLine: {show: false},
                            axisTick: {show: false},
                            splitLine: {show: false}
                        }
                    ],
                    dataZoom: [
                        {
                            type: 'inside',
                            xAxisIndex: [0, 1],
                            start: 98,
                            end: 100
                        },
                        {
                            show: true,
                            xAxisIndex: [0, 1],
                            type: 'slider',
                            top: '85%',
                            start: 98,
                            end: 100
                        }
                    ],
                    series: [
                        {
                            name: 'Dow-Jones index',
                            type: 'candlestick',
                            data: data.values,
                            itemStyle: {
                                normal: {
                                    color: $scope.upColor,
                                    color0: $scope.downColor,
                                    borderColor: null,
                                    borderColor0: null
                                }
                            },
                            tooltip: {
                                formatter: function (param) {
                                    param = param[0];
                                    return [
                                        'Date: ' + param.name + '<hr size=1 style="margin: 3px 0">',
                                        'Open: ' + param.data[0] + '<br/>',
                                        'Close: ' + param.data[1] + '<br/>',
                                        'Lowest: ' + param.data[2] + '<br/>',
                                        'Highest: ' + param.data[3] + '<br/>'
                                    ].join('');
                                }
                            }
                        },
                        {
                            name: 'MA5',
                            type: 'line',
                            data: $scope.calculateMA(5, data),
                            smooth: true,
                            lineStyle: {
                                normal: {opacity: 0.5}
                            }
                        },
                        {
                            name: 'MA10',
                            type: 'line',
                            data: $scope.calculateMA(10, data),
                            smooth: true,
                            lineStyle: {
                                normal: {opacity: 0.5}
                            }
                        },
                        {
                            name: 'MA20',
                            type: 'line',
                            data: $scope.calculateMA(20, data),
                            smooth: true,
                            lineStyle: {
                                normal: {opacity: 0.5}
                            }
                        },
                        {
                            name: 'Volume',
                            type: 'bar',
                            xAxisIndex: 1,
                            yAxisIndex: 1,
                            data: data.volumes
                        }
                    ]
                }, true);
                myChart.dispatchAction({
                    type: 'brush',
                    areas: [
                        {
                            brushType: 'lineX',
                            coordRange: ['2016-06-02', '2016-06-20'],
                            xAxisIndex: 0
                        }
                    ]
                });
            }
            else
                alert("不存在这支股票。");
        }, function errorCallback(response) {
            alert("Error");
        });
    };



    $scope.initData();
});