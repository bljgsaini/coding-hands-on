package designPattern.behavioral.iteratorPattern.itemIterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Item pens = new Item("pen", 50);
        Item pencils = new Item("pencils", 0);
        Item papers = new Item("papers", 20);

        Inventory inventory = new Inventory(pens, pencils, papers);

        Iterator iterator = inventory.getIterator();

        while(iterator.hasNext()){
            Item item = (Item) iterator.next();
            System.out.println(item.getName());
        }

    }

}
