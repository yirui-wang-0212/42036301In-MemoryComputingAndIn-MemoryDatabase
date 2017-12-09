package sixaps.stock.Mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import sixaps.stock.Model.Stock;
import sixaps.stock.Model.StockGroup;

import java.util.List;

@Mapper
public interface StockMapper {

    @Select("CALL sixapsTest(#{id, mode=IN},#{code, mode=OUT, jdbcType=CURSOR})")
    @Options(statementType = StatementType.CALLABLE)
    void sixapsTest(@Param("id") double id, @Param("code") List<String> codes);
}
