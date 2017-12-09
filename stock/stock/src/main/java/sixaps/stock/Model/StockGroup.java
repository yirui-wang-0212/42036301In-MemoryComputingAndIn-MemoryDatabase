package sixaps.stock.Model;

import java.util.ArrayList;
import java.util.List;

public class StockGroup {
    private double id;
    private List<String> codes = new ArrayList<String>();

    public List<String> getCodes() {
        return codes;
    }

    public void setId(double id) {
        this.id = id;
    }
}
