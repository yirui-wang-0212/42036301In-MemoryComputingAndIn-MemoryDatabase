package sixaps.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sixaps.stock.Mapper.TestMapper;

@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Object getCount(){
        return testMapper.getCount();
    }

}
