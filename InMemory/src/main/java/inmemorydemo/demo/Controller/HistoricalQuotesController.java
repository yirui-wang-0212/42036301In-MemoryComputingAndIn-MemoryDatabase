package inmemorydemo.demo.Controller;

import inmemorydemo.demo.Mapper.HistoricalQuotesMapper;
import inmemorydemo.demo.Model.HistoricalQuotesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/history")
public class HistoricalQuotesController {

    @Autowired
    private HistoricalQuotesMapper historicalQuotesMapper;

//    @GetMapping("/getHistoricalQuotesData")
//    public ArrayList<HistoricalQuotesModel> getHistoricalQuotesData(){
//
//        ArrayList<HistoricalQuotesModel> historicalQuotesMapperArrayList = historicalQuotesMapper.getData("600112");
//
//        return historicalQuotesMapperArrayList;
//
//    }

    @PostMapping(value = "/days")
    @ResponseBody
    public Object getHistoricalQuotesData1(@RequestBody Map<String,Object> requestBody){

        System.out.println("hello");

        ArrayList<HistoricalQuotesModel> historicalQuotesModelList = historicalQuotesMapper.getData(requestBody.get("code").toString());

        ArrayList<ArrayList<Object>> responseLists = new ArrayList<>();

        for (HistoricalQuotesModel historicalQuotesModel : historicalQuotesModelList){
            ArrayList<Object> objectArrayList = new ArrayList<>();
//            objectArrayList.add(historicalQuotesModel.getCode());
            DecimalFormat df = new DecimalFormat("#.000");
            objectArrayList.add(historicalQuotesModel.getTrading_day().substring(0,10));
            objectArrayList.add(df.format(historicalQuotesModel.getOpen_value()));
            objectArrayList.add(df.format(historicalQuotesModel.getClose_value()));
            objectArrayList.add(df.format(historicalQuotesModel.getLow_value()));
            objectArrayList.add(df.format(historicalQuotesModel.getHigh_value()));
            objectArrayList.add(df.format(historicalQuotesModel.getMa5()));
            objectArrayList.add(df.format(historicalQuotesModel.getMa10()));
            objectArrayList.add(df.format(historicalQuotesModel.getMa20()));
            objectArrayList.add(df.format(historicalQuotesModel.getVolume_value()));
            responseLists.add(objectArrayList);
        }

        return responseLists;

    }


}
