package designPattern.behavioral.visitorPattern.example1.end;

public class Bread implements Grocery {

    private double price = 1;

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
