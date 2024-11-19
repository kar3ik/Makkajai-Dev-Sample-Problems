import java.util.Scanner;

public class InputHandler {
    public static ShoppingCart readInput() {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Enter items (format: '<quantity> <product name> at <price>'), or type 'done' to finish:");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("done")) break;

            String[] parts = line.split(" at ");
            if (parts.length < 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            String nameAndQuantity = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());

            String[] nameParts = nameAndQuantity.split(" ", 2);
            int quantity = Integer.parseInt(nameParts[0].trim());
            String name = nameParts[1].trim();

            boolean isImported = name.contains("imported");
            boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pill");

            cart.addProduct(new Product(name, price, isImported, isExempt), quantity);
        }
        scanner.close();
        return cart;
    }
}
