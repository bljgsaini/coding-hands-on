package designPattern.structural.proxy.storeInventoryExample.end;

public class Main {

  public static void main(String[] args) {
    Inventory inventory = new SuperstoreInventoryProxy();
    Store store = new Store("Healthy Wholefoods", "Los Angeles", inventory);
    store.printName();
    store.printLocation();
    store.printInventory();
  }

}
