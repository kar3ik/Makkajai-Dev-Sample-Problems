import java.util.List;

public class Receipt {
    private List<Product> products;

    public Receipt(List<Product> products) {
        this.products = products;
    }

    public void printReceipt() {
        double totalSalesTaxes = 0;
        double totalCost = 0;

        for (Product product : products) {
            double salesTax = TaxCalculator.calculateSalesTax(product);
            double importDuty = TaxCalculator.calculateImportDuty(product);
            double productCost = product.getPrice() + salesTax + importDuty;

            totalSalesTaxes += salesTax + importDuty;
            totalCost += productCost;

            System.out.println(product.getName() + ": " + String.format("%.2f", productCost));
        }

        System.out.println("Sales Taxes: " + String.format("%.2f", totalSalesTaxes));
        System.out.println("Total: " + String.format("%.2f", totalCost));
    }
}
