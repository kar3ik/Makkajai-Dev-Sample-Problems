import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalTax() {
        return products.stream()
                .mapToDouble(TaxCalculator::calculateTax)
                .sum();
    }

    public double calculateTotalPrice() {
        return products.stream()
                .mapToDouble(product -> product.getPrice() + TaxCalculator.calculateTax(product))
                .sum();
    }
}
