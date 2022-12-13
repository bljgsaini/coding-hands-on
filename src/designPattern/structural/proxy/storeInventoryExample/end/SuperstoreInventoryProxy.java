package designPattern.structural.proxy.storeInventoryExample.end;

import java.util.ArrayList;
import java.util.Objects;

public class SuperstoreInventoryProxy implements Inventory{
    private SuperstoreInventory superstoreInventory;

    @Override
    public ArrayList<Item> getInventory() {
        if(Objects.isNull(superstoreInventory)){
            superstoreInventory = new SuperstoreInventory();
        }
        return superstoreInventory.getInventory();
    }
}
