package inmemorydemo.demo.Controller;

import inmemorydemo.demo.Mapper.WeatherMapper;
import inmemorydemo.demo.Model.ResponseChart;
import inmemorydemo.demo.Model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


// Restful API

@RestController
public class MyChartController {

    @Autowired
    private WeatherMapper weatherMapper;

    @RequestMapping("/getChartData")
    public ResponseChart getChartData(){

        ResponseChart responseChart = new ResponseChart();


        // 从数据库获取数据
        ArrayList<Weather> weathers = weatherMapper.getWeathers();
        for (Weather weather : weathers){
            //System.out.println(weather.getMon()+","+weather.getTemperature());

            responseChart.xdatas.add(weather.getMon());
            responseChart.ydatas.add(weather.getTemperature());

        }

        // 返回数据，会自动变为 JSON
        return responseChart;

    }
}
