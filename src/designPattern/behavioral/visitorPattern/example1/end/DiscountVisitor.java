package designPattern.behavioral.visitorPattern.example1.end;

public class DiscountVisitor implements Visitor{
    @Override
    public void visit(Bread bread) {
        bread.setPrice(0.9);
    }

    @Override
    public void visit(Milk milk) {
        milk.setPrice(1.6);
    }

    @Override
    public void visit(GroceriesList groceriesList) {
        System.out.println("Discount has been applied to the groceries list");
    }
}
