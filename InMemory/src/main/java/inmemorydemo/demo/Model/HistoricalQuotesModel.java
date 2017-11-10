package inmemorydemo.demo.Model;

// 历史交易数据
public class HistoricalQuotesModel {

    private String code;

    private double open_value;

    private double high_value;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOpen_value() {
        return open_value;
    }

    public void setOpen_value(double open_value) {
        this.open_value = open_value;
    }


    public double getHigh_value() {
        return high_value;
    }

    public void setHigh_value(double high_value) {
        this.high_value = high_value;
    }
}
