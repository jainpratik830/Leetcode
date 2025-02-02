package LLD.Car_Rental.Payment;

public class PayPalPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        // Process paypal payment
        // ...
        return true;
    }
}
