package murach.business;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
public class Product implements Serializable {
    private String code;
    private String description;
    private double price;

    public Product(){}
    public Product (String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getPriceCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(price);
    }
}
