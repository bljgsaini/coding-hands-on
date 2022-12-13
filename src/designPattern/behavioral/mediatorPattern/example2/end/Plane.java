package designPattern.behavioral.mediatorPattern.example2.end;

public class Plane {
    private String id;
    private boolean isInFlight;

    public Plane(String id){
        this.id = id;
        isInFlight = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInFlight() {
        return isInFlight;
    }

    public void setInFlight(boolean inFlight) {
        isInFlight = inFlight;
    }
}
