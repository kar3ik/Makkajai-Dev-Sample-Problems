import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                // If product already exists, update the quantity
                int updatedQuantity = item.getQuantity() + quantity;
                items.remove(item);
                items.add(new CartItem(product, updatedQuantity));
                return;
            }
        }
        // Otherwise, add a new CartItem
        items.add(new CartItem(product, quantity));
    }

    public double calculateTotalTax() {
        return items.stream()
                .mapToDouble(CartItem::getTax)
                .sum();
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public List<CartItem> getItems() {
        return items;
    }
}
