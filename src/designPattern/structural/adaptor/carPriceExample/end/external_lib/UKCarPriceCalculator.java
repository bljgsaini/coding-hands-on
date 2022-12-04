package designPattern.structural.adaptor.carPriceExample.end.external_lib;

public class UKCarPriceCalculator {

    private int age;
    private String model;

    private static int averageCarPrice = 7000;

    public UKCarPriceCalculator(String model, int age){
        this.age = age;
        this.model = model;
    }

    public int getPrice(){
        switch (model) {
            case "Ford":
                return 4000;
            case "Audi":
                return 6000;
            case "BMW":
                return 8000;
            case "Tesla":
                return 11000;
            default:
                return averageCarPrice;
        }
    }

}
