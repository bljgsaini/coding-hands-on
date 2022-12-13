package designPattern.behavioral.strategyPattern.makePayment.solution3;

public class Customer {

  public void makePayment(PaymentService paymentService, int amount){
    paymentService.makePayment(amount);
  }

}
