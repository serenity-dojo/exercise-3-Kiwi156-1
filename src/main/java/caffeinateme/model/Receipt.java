package caffeinateme.model;

import java.util.List;

public class Receipt {

    private double subtotal;

    private double total;

    private double serviceFee;

    public Receipt(double subtotal, double total, double serviceFee, List<ReceiptLineItem> lineItems) {
        this.subtotal = subtotal;
        this.total = total;
        this.serviceFee = serviceFee;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() { return total;}

    public double getServiceFee() {
        return serviceFee;
    }



    @Override
    public String toString() {
        return "Receipt{" +
                "subtotal=" + subtotal +
                ", total=" + total +
                ", serviceFee=" + serviceFee +
                '}';
    }
}
