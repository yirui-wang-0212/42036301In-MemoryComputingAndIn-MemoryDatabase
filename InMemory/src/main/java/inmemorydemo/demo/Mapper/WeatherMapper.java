package inmemorydemo.demo.Mapper;

import inmemorydemo.demo.Model.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


// 数据库访问类/接口

@Mapper
public interface WeatherMapper {

    @Select("SELECT * FROM WEATHER")
    ArrayList<Weather> getWeathers();

}
