import java.util.List;

public class OutputHandler {
    public static void printReceipt(Receipt receipt) {
        List<String> lines = receipt.generateReceipt();
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
