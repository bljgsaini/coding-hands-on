package designPattern.behavioral.strategyPattern.makePayment.solution3;

public class Main {

  public static void main(String[] args) {
    Customer customer = new Customer();
    customer.makePayment(PaymentService.BankPaymentService, 100);
  }

}
