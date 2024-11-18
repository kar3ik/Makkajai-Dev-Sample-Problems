public class TaxCalculator {
    private static final double BASIC_SALES_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    public static double calculateTax(Product product) {
        double basicTax = product.isExempt() ? 0 : product.getPrice() * BASIC_SALES_TAX_RATE;
        double importTax = product.isImported() ? product.getPrice() * IMPORT_DUTY_RATE : 0;
        return Utility.roundToNearest05(basicTax + importTax);
    }
}
