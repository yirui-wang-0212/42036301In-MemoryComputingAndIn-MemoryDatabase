package sixaps.stock.Controller;

import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sixaps.stock.Mapper.StockMapper;
import sixaps.stock.Model.Stock;
import sixaps.stock.Model.StockGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class StockController {
    @Autowired
    private StockMapper stockMapper;

    @RequestMapping(value = "/getDays", method = RequestMethod.GET)
    public Object getDays(@RequestParam("code") String code){
        Map<Object, Object> res = new HashMap<>();
        StockGroup stockGroup = new StockGroup();
        try {
            stockGroup.setCode(code);
            stockMapper.get_Data_Days(stockGroup);
            List<List<Object>> matData = new ArrayList<>();
            List<Object> temp;
            for (Stock i : stockGroup.getStocks()) {
                if(i.getVolume_value() <=0)
                    continue;
                temp = new ArrayList<Object>();
                temp.add(i.getTrading_day());
                temp.add(i.getOpen_value());
                temp.add(i.getClose_value());
                temp.add(i.getLow_value());
                temp.add(i.getHigh_value());
                temp.add(i.getVolume_value());
                matData.add(temp);
            }
            res.put("Data", matData);
            res.put("flag", true);
            return res;
        }
        catch(Exception e){
            res.put("flag",false);
            return res;
        }
    }

    @RequestMapping(value = "/getMonths", method = RequestMethod.GET)
    public Object getMonths(@RequestParam("code") String code){
        Map<Object, Object> res = new HashMap<>();
        StockGroup stockGroup = new StockGroup();
        try {
            stockGroup.setCode(code);
            stockMapper.get_Data_Months(stockGroup);
            List<List<Object>> matData = new ArrayList<>();
            List<Object> temp;
            for (Stock i : stockGroup.getStocks()) {
                if(i.getVolume_value() <=0)
                    continue;
                temp = new ArrayList<Object>();
                temp.add(i.getTrading_day());
                temp.add(i.getOpen_value());
                temp.add(i.getClose_value());
                temp.add(i.getLow_value());
                temp.add(i.getHigh_value());
                temp.add(i.getVolume_value());
                matData.add(temp);
            }
            res.put("Data", matData);
            res.put("flag", true);
            return res;
        }
        catch (Exception e){
            res.put("flag",false);
            return res;
        }
    }

    @RequestMapping(value = "/getWeeks", method = RequestMethod.GET)
    public Object getWeeks(@RequestParam("code") String code){
        Map<Object, Object> res = new HashMap<>();
        StockGroup stockGroup = new StockGroup();
        try {
            stockGroup.setCode(code);
            stockMapper.get_Data_Weeks(stockGroup);
            List<List<Object>> matData = new ArrayList<>();
            List<Object> temp;
            for (Stock i : stockGroup.getStocks()) {
                if(i.getVolume_value() <=0)
                    continue;
                temp = new ArrayList<Object>();
                temp.add(i.getTrading_day());
                temp.add(i.getOpen_value());
                temp.add(i.getClose_value());
                temp.add(i.getLow_value());
                temp.add(i.getHigh_value());
                temp.add(i.getVolume_value());
                matData.add(temp);
            }
            res.put("Data", matData);
            res.put("flag", true);
            return res;
        }
        catch (Exception e){
            res.put("flag",false);
            return res;
        }

    }

    @RequestMapping(value = "/getRealTime", method = RequestMethod.GET)
    public Object getRealTime(@RequestParam("code") String code){
        Map<Object, Object> res = new HashMap<>();
        try {
            List<Stock> stocks = stockMapper.get_Data_Real_Time(code);
            List<List<Object>> matData = new ArrayList<>();
            List<Object> temp;
            for (Stock i : stocks) {
                temp = new ArrayList<Object>();
                temp.add(i.getTrading_day());
                temp.add(i.getOpen_value());
                temp.add(i.getClose_value());
                temp.add(i.getLow_value());
                temp.add(i.getHigh_value());
                temp.add(i.getVolume_value());
                matData.add(temp);
            }
            res.put("Data", matData);
            res.put("flag", true);
            return res;
        }
        catch (Exception e){
            res.put("flag",false);
            return res;
        }
    }
}
