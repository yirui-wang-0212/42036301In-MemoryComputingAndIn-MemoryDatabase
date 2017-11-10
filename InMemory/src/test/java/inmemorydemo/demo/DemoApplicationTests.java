package inmemorydemo.demo;

import inmemorydemo.demo.Mapper.HistoricalQuotesMapper;
import inmemorydemo.demo.Mapper.WeatherMapper;
import inmemorydemo.demo.Model.HistoricalQuotesModel;
import inmemorydemo.demo.Model.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	private WeatherMapper weatherMapper;

	@Autowired
	private HistoricalQuotesMapper historicalQuotesMapper;

	@Test
	public void contextLoads() {

//		ArrayList<Weather> weathers = weatherMapper.getWeathers();
//		for (Weather weather : weathers){
//			System.out.println(weather.getMon()+","+weather.getTemperature());
//		}

//		ArrayList<HistoricalQuotesModel> historicalQuotesMapperArrayList = historicalQuotesMapper.getData();
//
//		for (HistoricalQuotesModel historicalQuotesModel : historicalQuotesMapperArrayList){
////			System.out.println(historicalQuotesModel.getCode()
////					+ "," + historicalQuotesModel.getTrading_day()
////					+ "," + historicalQuotesModel.getOpen_value()
////					+ "," + historicalQuotesModel.getHigh_value());
//			System.out.println(historicalQuotesModel);
//		}

	}

}
