package designPattern.behavioral.observalPatternExample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class City {

    String trafficUpdate = "good";

    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setTrafficUpdate(String status){
        support.firePropertyChange("trafficUpdate", this.trafficUpdate, status);
        this.trafficUpdate = status;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }




}
