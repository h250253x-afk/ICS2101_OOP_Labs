abstract class Payment {}

class CardPayment extends Payment {
    void processCard() { System.out.println("Processing Card Payment via Gateway..."); }
}

class MobileMoneyPayment extends Payment {
    void processMobile() { System.out.println("Processing Mobile Money via SMS API..."); }
}

interface PolymorphicPayment {
    void process();
}

class CardPaymentPoly implements PolymorphicPayment {
    @Override
    public void process() { System.out.println("Polymorphic: Processing Card Payment..."); }
}

class MobileMoneyPaymentPoly implements PolymorphicPayment {
    @Override
    public void process() { System.out.println("Polymorphic: Processing Mobile Money..."); }
}

public class PaymentProcessor {
    public static void processWithInstanceof(Payment p) {
        if (p instanceof CardPayment c) {
            c.processCard();
        } else if (p instanceof MobileMoneyPayment m) {
            m.processMobile();
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Approach 1: instanceof Pattern Matching ---");
        processWithInstanceof(new CardPayment());
        processWithInstanceof(new MobileMoneyPayment());

        System.out.println("\n--- Approach 2: Pure Polymorphism ---");
        PolymorphicPayment[] payments = {
            new CardPaymentPoly(),
            new MobileMoneyPaymentPoly()
        };

        for (PolymorphicPayment p : payments) {
            p.process();
        }
    }
}