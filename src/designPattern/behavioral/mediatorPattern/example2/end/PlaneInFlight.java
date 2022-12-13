package designPattern.behavioral.mediatorPattern.example2.end;

import java.util.ArrayList;
import java.util.List;

public class PlaneInFlight {

    private List<Plane> planeInFlight;

    public PlaneInFlight() {
        this.planeInFlight = new ArrayList<Plane>();
    }

    public void addFlight(Plane plane){
        planeInFlight.add(plane);
    }

    public void removeFlight(Plane plane){
        planeInFlight.remove(plane);
    }

}
