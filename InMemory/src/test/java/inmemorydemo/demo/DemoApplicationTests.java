package inmemorydemo.demo;

import inmemorydemo.demo.Mapper.WeatherMapper;
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

	@Test
	public void contextLoads() {

		ArrayList<Weather> weathers = weatherMapper.getWeathers();
		for (Weather weather : weathers){
			System.out.println(weather.getMon()+","+weather.getTemperature());
		}


	}

}
