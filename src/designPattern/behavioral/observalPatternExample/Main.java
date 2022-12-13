package designPattern.behavioral.observalPatternExample;

public class Main {

    public static void main(String[] args) {
        City bengaluru = new City();
        City mumbai = new City();

        TrafficFeed feed = new TrafficFeed();
        bengaluru.addPropertyChangeListener(feed);
        mumbai.addPropertyChangeListener(feed);

        bengaluru.setTrafficUpdate("There is heavy traffic on bridge");
        mumbai.setTrafficUpdate("there is accident on the road");

        feed.getUpdates();
    }


}
