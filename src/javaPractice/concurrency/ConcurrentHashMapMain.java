package javaPractice.concurrency;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMain {
    public static void main(String[] args) {
        Country india = new Country("India", 10000l);
        Country japan = new Country("Japan", 10001l);
        Country russia = new Country("Russia", 10002l);
        Country england = new Country("England", 10003l);

        ConcurrentHashMap<Country, Long> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(india, india.population);
        concurrentHashMap.put(japan, japan.population);
        concurrentHashMap.put(russia, russia.population);
        concurrentHashMap.put(england, england.population);

        Iterator countryIterator = concurrentHashMap.keySet().iterator();
        while(countryIterator.hasNext()){
            Country country = (Country)countryIterator.next();
            System.out.println("Country name : " + country.getName() + " : population =>" + concurrentHashMap.get(country));
        }

    }
}


class Country{
    String name;
    Long population;

    public Country(String name, Long population){
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equalsIgnoreCase(country.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
