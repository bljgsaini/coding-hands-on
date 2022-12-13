package designPattern.behavioral.visitorPattern.example1.end;

import java.util.ArrayList;
import java.util.List;

public class GroceriesList implements Grocery {

    private List<Grocery> groceryList;

    public GroceriesList(){
        Bread bread1 = new Bread();
        Bread bread2 = new Bread();
        Milk milk = new Milk();
        groceryList = new ArrayList<>();
        groceryList.add(bread1);
        groceryList.add(milk);
        groceryList.add(bread2);
    }

    public double getPrice(){
        return groceryList.stream().mapToDouble(Grocery:: getPrice).sum();
    }

    @Override
    public void accept(Visitor visitor) {
        groceryList.forEach( g-> g.accept(visitor));
        visitor.visit(this);
    }

}
