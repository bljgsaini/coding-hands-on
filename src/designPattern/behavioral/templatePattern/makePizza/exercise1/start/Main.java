package designPattern.behavioral.templatePattern.makePizza.exercise1.start;

public class Main {

  public static void main(String[] args) {
    VegetarianPizza vegetarian = new VegetarianPizza();
    vegetarian.printInstructions();

    MeatFeastPizza meatFeast = new MeatFeastPizza();
    meatFeast.printInstructions();
  }

}
