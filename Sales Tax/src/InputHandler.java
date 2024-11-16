import java.util.Scanner;

public class InputHandler {
    public static Receipt readInput() {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("Enter products (format: name at price [imported/exempt]), or type 'done' to finish:");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("done")) break;

            String[] parts = line.split(" at ");
            if (parts.length < 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            String name = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            boolean isImported = name.contains("imported");
            boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pill");

            receipt.addProduct(new Product(name, price, isImported, isExempt));
        }
        scanner.close();
        return receipt;
    }
}
