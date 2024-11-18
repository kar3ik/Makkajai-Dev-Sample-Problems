public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = InputHandler.readInput();
        OutputHandler.printReceipt(cart);
    }
}
