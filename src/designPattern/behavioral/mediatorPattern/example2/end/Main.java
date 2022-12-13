package designPattern.behavioral.mediatorPattern.example2.end;

public class Main {

    public static void main(String[] args) {
        Plane plane1 = new Plane("AI-354");
        Mediator mediator = new Mediator();
        mediator.addNewFlight(plane1);
        mediator.takeOff(plane1);
    }

}
