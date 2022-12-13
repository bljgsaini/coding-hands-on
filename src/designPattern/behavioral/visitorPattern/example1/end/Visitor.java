package designPattern.behavioral.visitorPattern.example1.end;


public interface Visitor {
    void visit(Bread bread);
    void visit(Milk milk);
    void visit(GroceriesList groceriesList);
}
