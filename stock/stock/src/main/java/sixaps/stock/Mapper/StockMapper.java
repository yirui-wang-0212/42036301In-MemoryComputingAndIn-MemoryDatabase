package sixaps.stock.Mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import sixaps.stock.Model.Stock;
import sixaps.stock.Model.StockGroup;

import java.util.List;

@Mapper
public interface StockMapper {

//    @Select("CALL sixapsTest(#{id, mode=IN},#{stocks, mode=OUT, jdbcType=CURSOR, javaType=java.sql.ResultSet, resultMap=test })")
//    @Options(statementType = StatementType.CALLABLE)
    void get_Data_Days(StockGroup stockGroup);

    void get_Data_Weeks(StockGroup stockGroup);

    void get_Data_Months(StockGroup stockGroup);

    List<Stock> get_Data_Real_Time(String code);

}
