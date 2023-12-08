package caffeinateme.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptLineItem {

    private final String product;
    private final int quantity;

    private final double price;

    public ReceiptLineItem(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ReceiptLineItem{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}