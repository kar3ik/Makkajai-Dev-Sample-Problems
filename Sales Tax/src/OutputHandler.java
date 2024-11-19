public class OutputHandler {
    public static void printReceipt(ShoppingCart cart) {
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + " " + item.getProduct().getName() + ": " +
                    String.format("%.2f", item.getTotalPrice()));
        }

        System.out.println("Sales Taxes: " + String.format("%.2f", cart.calculateTotalTax()));
        System.out.println("Total: " + String.format("%.2f", cart.calculateTotalPrice()));
    }
}
