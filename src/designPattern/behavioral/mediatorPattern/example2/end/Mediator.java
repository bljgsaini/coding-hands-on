package designPattern.behavioral.mediatorPattern.example2.end;

public class Mediator {

    private PlaneInFlight planeInFlight;
    private PlaneOnGround planeOnGround;
    private Runway runway;

    public Mediator(){
        planeInFlight = new PlaneInFlight();
        planeOnGround = new PlaneOnGround();
        runway = new Runway();
    }

    public void takeOff(Plane plane){
        if( !plane.isInFlight() && runway.isRunwayAvailable()){
            runway.setRunwayAvailable(false);
            plane.setInFlight(true);
            System.out.println("flight=>" + plane.getId() + " taking off ");
            planeOnGround.removeFlight(plane);
            planeInFlight.addFlight(plane);
        }
    }

    public void addNewFlight(Plane plane){
        planeOnGround.addFlight(plane);
    }

}
