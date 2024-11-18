public class Utility {
    public static double roundToNearest05(double amount) {
        return Math.ceil(amount * 20) / 20.0;
    }
}
