package designPattern.behavioral.mediatorPattern.example2.end;

import java.util.ArrayList;
import java.util.List;

public class PlaneOnGround {

    private List<Plane> planeOnGround;

    public PlaneOnGround() {
        this.planeOnGround = new ArrayList<Plane>();
    }

    public void addFlight(Plane plane){
        planeOnGround.add(plane);
    }

    public void removeFlight(Plane plane){
        planeOnGround.remove(plane);
    }

}
