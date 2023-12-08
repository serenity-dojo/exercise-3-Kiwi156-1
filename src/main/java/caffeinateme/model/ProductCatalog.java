package caffeinateme.model;

import caffeinateme.model.ProductPrice;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {

    List<ProductPrice> catalog = new ArrayList<>();

    public ProductCatalog() {
    }


    public void addProductsWithPrices(List<ProductPrice> productPrices) {
        catalog.addAll(productPrices);
    }

    public double priceOf(String productName) {
        return catalog.stream()
                .filter(product -> product.getProduct().equals(productName))
                .findFirst()
                .orElseThrow(UnknownError::new)
                .getPrice();
    }
}
