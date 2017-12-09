package sixaps.stock.Model;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class Stock {
     private String code;
     private String trading_day;
     private double open_value;
     private double close_value;
     private double high_value;
     private double low_value;
     private double volume_value;

     public void setCode(String code) {
          this.code = code;
     }

     public String getCode() {
          return code;
     }

     public String getTrading_day() {
          return trading_day;
     }

     public double getClose_value() {
          return close_value;
     }

     public double getHigh_value() {
          return high_value;
     }

     public double getLow_value() {
          return low_value;
     }

     public double getOpen_value() {
          return open_value;
     }

     public double getVolume_value() {
          return volume_value;
     }
}
