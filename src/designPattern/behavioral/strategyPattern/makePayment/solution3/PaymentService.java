package designPattern.behavioral.strategyPattern.makePayment.solution3;

public interface PaymentService {
    void makePayment(int amount);

    PaymentService PaypalPaymentService = (int amount) -> {
        System.out.println("making the payment of $"+ amount+ " using Paypal");
    };

    PaymentService BankPaymentService = (int amount) -> {
        System.out.println("making the payment of $"+ amount+ " using bankAccount");
    };

}
