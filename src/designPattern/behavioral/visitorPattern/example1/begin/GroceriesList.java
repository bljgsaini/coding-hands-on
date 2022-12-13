package designPattern.behavioral.visitorPattern.example1.begin;

import java.util.ArrayList;
import java.util.List;

public class GroceriesList {

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

}
