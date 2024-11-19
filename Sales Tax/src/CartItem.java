public class CartItem {
    private Product product;
    private int quantity;
    private double tax; // Computed once
    private double totalPrice; // Computed once

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.tax = calculateTax();
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTax() {
        double basicTax = product.isExempt() ? 0 : product.getPrice() * 0.10;
        double importDuty = product.isImported() ? product.getPrice() * 0.05 : 0;
        return Utility.roundToNearest05((basicTax + importDuty) * quantity);
    }

    private double calculateTotalPrice() {
        return (product.getPrice() * quantity) + tax;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
