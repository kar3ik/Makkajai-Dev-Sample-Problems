public class OutputHandler {
    public static void printReceipt(ShoppingCart cart) {
        double totalTax = cart.calculateTotalTax();
        double totalPrice = cart.calculateTotalPrice();

        for (Product product : cart.getProducts()) {
            double tax = TaxCalculator.calculateTax(product);
            System.out.println(product.getName() + ": " +
                    String.format("%.2f", product.getPrice() + tax));
        }

        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }
}
