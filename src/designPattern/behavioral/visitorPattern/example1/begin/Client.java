package designPattern.behavioral.visitorPattern.example1.begin;

public class Client {
    public static void main(String[] args) {
        GroceriesList groceriesList = new GroceriesList();
        System.out.println("Total grocery price : " + groceriesList.getPrice());
    }
}
