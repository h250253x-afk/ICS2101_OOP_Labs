public class BankAccWithdrawal {
    private double balance;

    public BankAccWithdrawal(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method that declares throwing our custom exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException(deficit);
        }
        balance -= amount;
        System.out.printf("Successfully withdrew $%.2f. Remaining balance: $%.2f%n", amount, balance);
    }

    public static void main(String[] args) {
        System.out.println("=== LAB 7: EXERCISE 4 (CUSTOM EXCEPTIONS) ===");

        BankAccWithdrawal account = new BankAccWithdrawal(100.00);

        System.out.println("Attempting to withdraw $40.00...");
        try {
            account.withdraw(40.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("\nAttempting to withdraw $150.00...");
        try {
            account.withdraw(150.00);
        } catch (InsufficientFundsException e) {
            System.err.println("Caught Custom Exception: " + e.getMessage());
            System.out.println("Deficit amount required: $" + String.format("%.2f", e.getAmountNeeded()));
        }
    }
}