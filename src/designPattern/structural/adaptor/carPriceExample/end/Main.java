package designPattern.structural.adaptor.carPriceExample.end;

import designPattern.structural.adaptor.carPriceExample.end.external_lib.UKCarPriceCalculator;

public class Main {

  public static void main(String[] args) {
    CarPriceCalculator carPriceCalculator = new CarPriceCalculator("Ford", 3);
    printVehiclePrice(carPriceCalculator);

    TruckPriceCalculator truckPriceCalculator = new TruckPriceCalculator(10, 0);
    printVehiclePrice(truckPriceCalculator);

    UKCarPriceCalculator ukCarPriceCalculator = new UKCarPriceCalculator("Ford", 3);
    Adaptor adaptor = new Adaptor(ukCarPriceCalculator);
    printVehiclePrice(adaptor);
  }

  public static void printVehiclePrice(PriceCalculator calculator) {
    String price = calculator.calculatePrice();
    System.out.println("The price of vehicle is: " + price);
  }

}
