package inmemorydemo.demo.Mapper;

import inmemorydemo.demo.Model.HistoricalQuotesModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface HistoricalQuotesMapper {

    @Select("SELECT CODE, OPEN_VALUE, HIGH_VALUE FROM HISTORICAL_QUOTES")
    ArrayList<HistoricalQuotesModel> getData();

}
