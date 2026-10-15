public class InsufficientFundsException extends Exception {
    private final double amountNeeded;

    public InsufficientFundsException(double amountNeeded) {
        super("Transaction failed: Insufficient funds. Short by $" + String.format("%.2f", amountNeeded));
        this.amountNeeded = amountNeeded;
    }

    public double getAmountNeeded() {
        return amountNeeded;
    }
}