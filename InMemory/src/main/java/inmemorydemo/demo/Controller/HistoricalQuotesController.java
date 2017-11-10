package inmemorydemo.demo.Controller;

import inmemorydemo.demo.Mapper.HistoricalQuotesMapper;
import inmemorydemo.demo.Model.HistoricalQuotesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//        ArrayList<ArrayList<Object>> responseLists = new ArrayList<>();
//
//        for (HistoricalQuotesModel historicalQuotesModel : historicalQuotesModelList){
//            ArrayList<Object> objectArrayList = new ArrayList<>();
////            objectArrayList.add(historicalQuotesModel.getCode());
//            objectArrayList.add(historicalQuotesModel.getOpen_value());
//            responseLists.add(objectArrayList);
//        }

        return historicalQuotesModelList;

    }


}
