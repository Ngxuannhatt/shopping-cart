package murach.business;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Locale;

public class Cart implements  Serializable {
    private ArrayList<LineItem> items;

    public Cart(){
       items = new ArrayList<>();
    }
    public ArrayList<LineItem> getItems(){
        return items;
    }
    public void addItems(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (LineItem lineItem: items) {
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    public void removeItems(LineItem item) {
        String code = item.getProduct().getCode();
        items.removeIf(lineItem -> lineItem.getProduct().getCode().equals(code));
    }

    public int getTotalQuantity() {
        int total =0;
        for (LineItem lineItem: items){
            total += lineItem.getQuantity();
        }
        return total;
    }
    public double getGrandTotal() {
        double grandTotal = 0;
        for (LineItem lineItem : items) {
            grandTotal += lineItem.getTotalPrice();
        }
        return grandTotal;
    }

    public String getTotalCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(this.getGrandTotal());
    }
}
