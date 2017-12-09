package sixaps.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sixaps.stock.Mapper.StockMapper;
import sixaps.stock.Model.StockGroup;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StockController {
    @Autowired
    private StockMapper stockMapper;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<String> test(){
        double id = 1219588;
        List<String> codes = new ArrayList<String>();
        stockMapper.sixapsTest(id, codes);
        for(int i = 0; i < codes.size();i++){
            System.out.println(codes.get(i));
        }
        System.out.println("2212");
        return codes;
    }
}
