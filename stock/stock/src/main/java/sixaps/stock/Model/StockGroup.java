package sixaps.stock.Model;

import org.apache.ibatis.cursor.*;

import java.util.ArrayList;
import java.util.List;

public class StockGroup {
    private String code;
    private List<Stock> stocks;

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
