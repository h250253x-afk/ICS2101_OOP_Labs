interface Payable {
    boolean processPayment(double amount);
    String getPaymentDetails();
}

class CreditCardPayment implements Payable {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardHolder, String cardNumber) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("  [Gateway] Contacting Card Network for %s...%n", cardHolder);
        System.out.printf("  [Success] Charged $%.2f to Card (ending in %s)%n", 
                amount, cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card (" + cardHolder + ")";
    }
}

class PayPalPayment implements Payable {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.printf("  [Gateway] Authenticating PayPal token for %s...%n", email);
        System.out.printf("  [Success] Transferred $%.2f via PayPal API%n", amount);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "PayPal Account (" + email + ")";
    }
}

public class PaymentGateway {

    public void checkout(Payable paymentMethod, double totalAmount) {
        System.out.println("--------------------------------------------------");
        System.out.println("Initiating checkout via: " + paymentMethod.getPaymentDetails());
        
        boolean status = paymentMethod.processPayment(totalAmount);
        
        if (status) {
            System.out.println("Status: TRANSACTION COMPLETE");
        } else {
            System.out.println("Status: TRANSACTION FAILED");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== LAB 6: CHALLENGE EXERCISE (PAYMENT GATEWAY) ===");

        PaymentGateway gateway = new PaymentGateway();

        Payable card = new CreditCardPayment("Tariro Moyo", "4111-2222-3333-4444");
        Payable paypal = new PayPalPayment("tariro@hit.ac.zw");

        gateway.checkout(card, 249.99);
        gateway.checkout(paypal, 75.50);
    }
}