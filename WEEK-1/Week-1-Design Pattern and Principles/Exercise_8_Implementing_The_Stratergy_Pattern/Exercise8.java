package Exercise_8_Implementing_The_Stratergy_Pattern;


interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card (Holder: " + cardHolder + ")");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal (Email: " + email + ")");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        if (strategy == null) {
            System.out.println("Payment strategy not set.");
        } else {
            strategy.pay(amount);
        }
    }
}

public class Exercise8 {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Vishwa Thulasi");
        context.setPaymentStrategy(creditCard);
        context.makePayment(1500.00);

        System.out.println();

        PaymentStrategy paypal = new PayPalPayment("vishwa@example.com");
        context.setPaymentStrategy(paypal);
        context.makePayment(2500.00);
    }
}
