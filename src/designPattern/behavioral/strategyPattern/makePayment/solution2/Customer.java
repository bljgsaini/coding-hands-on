package designPattern.behavioral.strategyPattern.makePayment.solution2;

public class Customer {

  public void makePayment(PaymentService paymentService, int amount){
    paymentService.makePayment(amount);
  }

}
