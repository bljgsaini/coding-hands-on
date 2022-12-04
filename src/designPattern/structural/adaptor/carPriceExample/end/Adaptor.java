package designPattern.structural.adaptor.carPriceExample.end;

import designPattern.structural.adaptor.carPriceExample.end.external_lib.UKCarPriceCalculator;

public class Adaptor implements PriceCalculator {

    private final UKCarPriceCalculator ukCarPriceCalculator;

    public Adaptor(UKCarPriceCalculator ukCarPriceCalculator){
        this.ukCarPriceCalculator = ukCarPriceCalculator;
    }
    @Override
    public String calculatePrice() {
        return ukCarPriceCalculator.getPrice() + "GWD";
    }
}
