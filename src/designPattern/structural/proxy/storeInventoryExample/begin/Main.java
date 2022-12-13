package designPattern.structural.proxy.storeInventoryExample.begin;

public class Main {

  public static void main(String[] args) {

    Inventory inventory = new SuperstoreInventory();
    Store store = new Store("Healthy Wholefoods", "Los Angeles", inventory);

    store.printName();
    store.printLocation();
    store.printInventory();


  }

}
