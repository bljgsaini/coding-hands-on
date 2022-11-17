package designPattern.behavioral.iteratorPattern.itemIterator;


import java.util.Iterator;

public class Inventory {

    private Item[] items;

    public Inventory(Item...items){
        this.items = items;
    }

    public Item[] getItems(){
        return items;

    }

    public Iterator getIterator(){
        return new StockIterator(this);
    }


}
