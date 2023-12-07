package caffeinateme.steps;


import caffeinateme.model.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

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

        @Then("the receipt should contain the line items:")
        public void the_receipt_should_contain_the_line_items(io.cucumber.datatable.DataTable dataTable) {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            // For other transformations you can register a DataTableType.
            throw new io.cucumber.java.PendingException();
        }

  */
    }
}