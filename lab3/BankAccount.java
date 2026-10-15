import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
        transactionHistory.add(String.format("Account opened with balance: $%.2f", openingBalance));
    }

    public String getAccountNumber() { 
        return accountNumber; 
    }

    public String getOwnerName() { 
        return ownerName; 
    }

    public double getBalance() { 
        return balance; 
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactionHistory.add(String.format("Deposited: $%.2f | New Balance: $%.2f", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            transactionHistory.add(String.format("FAILED Withdrawal attempt: $%.2f (Insufficient Funds)", amount));
            return false;
        }
        balance -= amount;
        transactionHistory.add(String.format("Withdrew: $%.2f | New Balance: $%.2f", amount, balance));
        return true;
    }

    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("1001", "Israel", 200.00);
        acc.deposit(200.00);
        acc.withdraw(150.00);
        acc.withdraw(1000.00);

        System.out.println("\nTransaction History Log:");
        for (String log : acc.getTransactionHistory()) {
            System.out.println(" - " + log);
        }

        System.out.println("\n--- Testing Unmodifiable List Protection ---");
        try {
            acc.getTransactionHistory().clear(); 
        } catch (UnsupportedOperationException e) {
            System.out.println("Encapsulation protected: Cannot directly clear transaction history!");
        }
    }
}
