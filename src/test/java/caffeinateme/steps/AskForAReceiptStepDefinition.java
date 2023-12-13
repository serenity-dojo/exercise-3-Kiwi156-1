package caffeinateme.steps;


import caffeinateme.model.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;



public class AskForAReceiptStepDefinition {

    Customer cathy = Customer.named("Cathy");

    Order order;

    CoffeeShop coffeeShop = new CoffeeShop();
    ProductCatalog productCatalog = new ProductCatalog();

    @Given("^the following prices:$")
    public void theFollowingPrices(List<ProductPrice> productPrices) throws Throwable {
        productCatalog.addProductsWithPrices(productPrices);
        coffeeShop.setProductCatalog(productCatalog);
    }

    @DataTableType
    public ProductPrice mapRowToProductPrice(Map<String, String> entry) {
        return new ProductPrice(entry.get("Product"), Double.parseDouble(entry.get("Price")));
    }

    @Given("^Cathy has ordered:$")
    public void cathy_has_ordered(List<OrderItem> orders) {
        for (OrderItem item : orders) {
            Order order =
                    Order.of(item.getQuantity(), item.getProduct()).forCustomer(cathy);
        coffeeShop.placeOrder(order);
        }

    }


    @DataTableType
    public OrderItem mapRowToOrderItem (Map<String, String> entry) {
        return new OrderItem(entry.get("Product"), Integer.parseInt(entry.get("Quantity")));

    }
        Receipt receipt;

        @When("^she asks for a receipt$")
        public void sheAsksForAReceipt() {
            receipt = coffeeShop.getReceiptFor(cathy);
        }

    @Then("^she should receive a receipt totalling:$")
    public void sheShouldReceiveAReceiptTotalling(List<Map<String, String>> receiptTotals) {
        System.out.println(receiptTotals);
        Double serviceFee = Double.parseDouble(receiptTotals.get(0).get("Service Fee"));
        Double subtotal = Double.parseDouble(receiptTotals.get(0).get("Subtotal"));
        Double total = Double.parseDouble(receiptTotals.get(0).get("Total"));

        assertThat(receipt.getServiceFee()).isEqualTo(serviceFee);
        assertThat(receipt.getSubtotal()).isEqualTo(subtotal);
        assertThat(receipt.getTotal()).isEqualTo(total);
    }

}
