package designPattern.behavioral.visitorPattern.example1.end;

public class Client {
    public static void main(String[] args) {
        GroceriesList groceriesList = new GroceriesList();
        System.out.println("Total grocery price : " + groceriesList.getPrice());
        groceriesList.accept(new DiscountVisitor());
        System.out.println("Total grocery price after discount : " + groceriesList.getPrice());
    }
}
