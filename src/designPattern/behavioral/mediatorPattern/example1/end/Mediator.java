package designPattern.behavioral.mediatorPattern.example1.end;

public class Mediator {

    private Customer customer;
    private ECommerceSite site;
    private Driver driver;

    public Mediator(String address){
        customer = new Customer(address);
        site = new ECommerceSite(customer);
        driver = new Driver();
    }

    public void buy(String item, int quantity){
        if(site.checkInStock(item, quantity)){
            site.sell(item,quantity);
            driver.deliver(item, quantity, customer);
        }
    }

}
