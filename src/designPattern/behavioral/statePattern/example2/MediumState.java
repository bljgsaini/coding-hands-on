package designPattern.behavioral.statePattern.example2;

public class MediumState implements State {

    @Override
    public void turnUp(Fan fan) {
        fan.setState(new HighState());
        System.out.println("Fan is at high");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new LowState());
        System.out.println("Fan is at low");
    }
}
