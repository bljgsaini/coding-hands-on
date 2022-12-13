package designPattern.behavioral.strategyPattern.makePayment.solution2;

public class BankPaymentService implements PaymentService{
    @Override
    public void makePayment(int amount) {
        System.out.println("making the payment of $"+ amount+ " using bankAccount");
    }
}
