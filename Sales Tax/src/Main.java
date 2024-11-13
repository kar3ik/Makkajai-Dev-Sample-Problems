import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test Case 1: Standard items (Book, CD, Chocolate Bar)
        List<Product> basket1 = new ArrayList<>();
        basket1.add(new Product("1 book", 12.49, false, true));
        basket1.add(new Product("1 music CD", 14.99, false, false));
        basket1.add(new Product("1 chocolate bar", 0.85, false, true));

        System.out.println("Receipt 1:");
        Receipt receipt1 = new Receipt(basket1);
        receipt1.printReceipt();

        // Test Case 2: Imported items (Chocolates and Perfume)
        List<Product> basket2 = new ArrayList<>();
        basket2.add(new Product("1 imported box of chocolates", 10.00, true, false));
        basket2.add(new Product("1 imported bottle of perfume", 47.50, true, false));

        System.out.println("\nReceipt 2:");
        Receipt receipt2 = new Receipt(basket2);
        receipt2.printReceipt();

        // Test Case 3: Mixed items (Imported and local)
        List<Product> basket3 = new ArrayList<>();
        basket3.add(new Product("1 imported bottle of perfume", 27.99, true, false));
        basket3.add(new Product("1 bottle of perfume", 18.99, false, false));
        basket3.add(new Product("1 packet of headache pills", 9.75, false, true));
        basket3.add(new Product("1 box of imported chocolates", 11.25, true, false));

        System.out.println("\nReceipt 3:");
        Receipt receipt3 = new Receipt(basket3);
        receipt3.printReceipt();
    }
}
