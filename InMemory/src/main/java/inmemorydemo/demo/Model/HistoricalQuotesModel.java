package inmemorydemo.demo.Model;

// 历史交易数据
public class HistoricalQuotesModel {

    private String code;

    private String trading_day;

    private double open_value;

    private double high_value;

    private double close_value;

    private double low_value;

    private double volume_value;

    private double price_change;

    private double p_change;

    private double ma5;

    private double ma10;

    private double ma20;

    private double v_ma5;

    private double v_ma10;

    private double v_ma20;

    private double turnover;


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


    public String getTrading_day() {
        return trading_day;
    }

    public void setTrading_day(String trading_day) {
        this.trading_day = trading_day;
    }

    public double getClose_value() {
        return close_value;
    }

    public void setClose_value(double close_value) {
        this.close_value = close_value;
    }

    public double getLow_value() {
        return low_value;
    }

    public void setLow_value(double low_value) {
        this.low_value = low_value;
    }

    public double getVolume_value() {
        return volume_value;
    }

    public void setVolume_value(double volume_value) {
        this.volume_value = volume_value;
    }

    public double getPrice_change() {
        return price_change;
    }

    public void setPrice_change(double price_change) {
        this.price_change = price_change;
    }

    public double getP_change() {
        return p_change;
    }

    public void setP_change(double p_change) {
        this.p_change = p_change;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getV_ma5() {
        return v_ma5;
    }

    public void setV_ma5(double v_ma5) {
        this.v_ma5 = v_ma5;
    }

    public double getV_ma10() {
        return v_ma10;
    }

    public void setV_ma10(double v_ma10) {
        this.v_ma10 = v_ma10;
    }

    public double getV_ma20() {
        return v_ma20;
    }

    public void setV_ma20(double v_ma20) {
        this.v_ma20 = v_ma20;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return getCode()
                + "," + getTrading_day()
                + "," + getOpen_value()
                + "," + getHigh_value()
                + "," + getClose_value()
                + "," + getLow_value()
                + "," + getVolume_value()
                + "," + getPrice_change()
                + "," + getP_change()
                + "," + getMa5()
                + "," + getMa10()
                + "," + getMa20()
                + "," + getV_ma5()
                + "," + getV_ma10()
                + "," + getV_ma20()
                + "," + getTurnover();
    }
}
