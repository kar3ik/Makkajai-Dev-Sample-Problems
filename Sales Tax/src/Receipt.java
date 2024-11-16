import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> products;

    public Receipt() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalTax() {
        return products.stream().mapToDouble(Product::getTax).sum();
    }

    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPriceAfterTax).sum();
    }

    public List<String> generateReceipt() {
        List<String> receiptLines = new ArrayList<>();
        for (Product product : products) {
            receiptLines.add(product.toString());
        }
        receiptLines.add("Sales Taxes: " + String.format("%.2f", calculateTotalTax()));
        receiptLines.add("Total: " + String.format("%.2f", calculateTotalPrice()));
        return receiptLines;
    }
}
