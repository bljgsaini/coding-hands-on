package designPattern.behavioral.visitorPattern.example1.begin;

public class Milk implements Grocery{

    private double price = 2;

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
