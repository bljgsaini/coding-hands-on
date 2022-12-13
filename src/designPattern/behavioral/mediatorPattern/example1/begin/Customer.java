package designPattern.behavioral.mediatorPattern.example1.begin;

public class Customer {

  private String address;
  private ECommerceSite site;

  public Customer(String address) {
    this.address = address;
    site = new ECommerceSite(this);
  }

  public String getAddress() {
    return address;
  }

  public void buy(String item, int quantity) {
    if(site.checkInStock(item, quantity)) {
      site.sell(item, quantity);
    }
  }

}
