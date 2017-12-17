package sixaps.stock.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface TestMapper {

    @Select("select ID from warehouse_data_days where id = 1")
    ArrayList<Integer> getCount();

}
