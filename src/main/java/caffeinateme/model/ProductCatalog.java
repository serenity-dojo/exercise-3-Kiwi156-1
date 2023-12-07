package caffeinateme.model;

import caffeinateme.model.ProductPrice;

import java.util.List;

public class ProductCatalog {

    private String product;

    private double price;

    public ProductCatalog() {
    }

    public ProductCatalog(String product, double price) {
        this.product = product;
        this.price = price;


    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }


    public void addProductsWithPrices(List<ProductPrice> productPrices) {
        System.out.println(productPrices);


    }
}
