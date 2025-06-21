package Exercise_4_Implementing_The_Adapter_Pattern;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amountInDollars) {
        System.out.println("PayPal: Payment of $" + amountInDollars + " processed.");
    }
}

class StripeGateway {
    public void sendPayment(double amountInRupees) {
        System.out.println("Stripe: Payment of " + amountInRupees + " processed.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.payPalGateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway gateway) {
        this.stripeGateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.sendPayment(amount);
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        PayPalGateway payPal = new PayPalGateway();
        PaymentProcessor paypalProcessor = new PayPalAdapter(payPal);
        paypalProcessor.processPayment(150.00); 

        System.out.println();

        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(12000.00); 
    }
}
