public class Product {
    private String name;
    private double price;
    private boolean isImported;
    private boolean isExempt;
    private double tax;

    private static final double BASIC_SALES_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    public Product(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.tax = calculateTax();
    }

    private double calculateTax() {
        double basicTax = isExempt ? 0 : price * BASIC_SALES_TAX_RATE;
        double importTax = isImported ? price * IMPORT_DUTY_RATE : 0;
        return roundToNearest05(basicTax + importTax);
    }

    private double roundToNearest05(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }

    public double getPriceAfterTax() {
        return price + tax;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return name + ": " + String.format("%.2f", getPriceAfterTax());
    }
}
