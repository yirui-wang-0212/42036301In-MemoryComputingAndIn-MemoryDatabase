package inmemorydemo.demo.Mapper;

import inmemorydemo.demo.Model.HistoricalQuotesModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface HistoricalQuotesMapper {

//    @Select("SELECT CODE, READING_DAY, OPEN_VALUE, HIGH_VALUE FROM HISTORICAL_QUOTES")
    @Select("select * from historical_quotes where code=${code}")
    ArrayList<HistoricalQuotesModel> getData(@Param("code") String code);

}
