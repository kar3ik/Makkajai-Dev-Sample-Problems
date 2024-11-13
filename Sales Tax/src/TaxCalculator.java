public class TaxCalculator {
    private static final double SALES_TAX_RATE = 0.10; // 10% Sales tax rate
    private static final double IMPORT_DUTY_RATE = 0.05; // 5% Import duty rate
    private static final double ROUNDING_FACTOR = 0.05;

    public static double calculateSalesTax(Product product) {
        if (product.isExempt()) {
            return 0;
        }
        return roundUp(product.getPrice() * SALES_TAX_RATE);
    }

    public static double calculateImportDuty(Product product) {
        if (!product.isImported()) {
            return 0;
        }
        return roundUp(product.getPrice() * IMPORT_DUTY_RATE);
    }

    private static double roundUp(double value) {
        return Math.ceil(value / ROUNDING_FACTOR) * ROUNDING_FACTOR;
    }
}
