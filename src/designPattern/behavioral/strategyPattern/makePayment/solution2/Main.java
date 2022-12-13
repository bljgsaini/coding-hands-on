package designPattern.behavioral.strategyPattern.makePayment.solution2;

public class Main {

  public static void main(String[] args) {
    Customer customer = new Customer();
    PaymentService paymentService = new PaypalPaymentService();
    customer.makePayment(paymentService, 100);
  }

}
