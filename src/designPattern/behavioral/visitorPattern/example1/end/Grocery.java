package designPattern.behavioral.visitorPattern.example1.end;

public interface Grocery {
    double getPrice();
    void accept(Visitor visitor);
}
