package Exercise4;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amountInDollars) {
        System.out.println("Processing PayPal payment of $" + amountInDollars);
    }
}

class StripeGateway {
    public void makePayment(double amountInRupees) {
        System.out.println("Processing Stripe payment of Rs " + amountInRupees);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount); // Assume amount is in USD
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount); // Assume amount is in INR
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using PayPal
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.00); // USD

        // Using Stripe
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(7500.00); // INR
    }
}
