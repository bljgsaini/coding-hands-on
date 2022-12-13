package designPattern.behavioral.mediatorPattern.example2.end;

public class Runway {
    private boolean isRunwayAvailable;

    public Runway() {
        this.isRunwayAvailable = true;
    }

    public boolean isRunwayAvailable() {
        return isRunwayAvailable;
    }

    public void setRunwayAvailable(boolean runwayAvailable) {
        isRunwayAvailable = runwayAvailable;
    }
}
