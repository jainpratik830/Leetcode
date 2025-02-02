package LLD.Car_Rental.Payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        // Process credit card payment
        // ...
        return true;
    }
}
