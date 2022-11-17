package designPattern.behavioral.iteratorPattern.itemIterator;

import java.net.InetSocketAddress;
import java.util.Iterator;

public class StockIterator implements Iterator {

    private Inventory inventory;

    private int index;

    public StockIterator(Inventory inventory){
        this.inventory = inventory;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        Item[] items = inventory.getItems();
        if(index < items.length) return true;
        return false;
    }

    @Override
    public Object next() {
        Item[] items = inventory.getItems();
        if(hasNext()){
            if(items[index].getQuantity() > 0){
                return items[index++];
            }else{
                index++;
                return next();
            }
        }else{
            return null;
        }
    }

    @Override
    public void remove() {

    }
}
