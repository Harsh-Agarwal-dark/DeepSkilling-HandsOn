package Exercise8;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    String cardNumber;
    String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card (" + cardHolder + ")");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}

class PaymentContext {
    public PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Alice");
        context.setPaymentStrategy(creditCard);
        context.executePayment(2500.0);

        // Switch to PayPal
        PaymentStrategy paypal = new PayPalPayment("bob@example.com");
        context.setPaymentStrategy(paypal);
        context.executePayment(1700.0);
    }
}
