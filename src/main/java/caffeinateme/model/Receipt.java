package caffeinateme.model;

public class Receipt {

    private double subtotal;

    private double Total;

    private double Service_Fee;

    public Receipt(double subtotal, double total, double service_Fee) {
        this.subtotal = subtotal;
        Total = total;
        Service_Fee = service_Fee;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return Total;
    }

    public double getService_Fee() {
        return Service_Fee;
    }
}
