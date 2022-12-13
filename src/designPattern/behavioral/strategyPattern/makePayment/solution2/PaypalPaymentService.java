package designPattern.behavioral.strategyPattern.makePayment.solution2;

public class PaypalPaymentService implements PaymentService{
    @Override
    public void makePayment(int amount) {
        System.out.println("making the payment of $"+ amount+ " using paypal");
    }
}
