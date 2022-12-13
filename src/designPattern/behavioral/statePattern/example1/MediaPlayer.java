package designPattern.behavioral.statePattern.example1;

public class MediaPlayer {
    private State state =  new PauseState();
    private String icon = "play icon";

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void play(){
       state.play(this);
    }


    public void pause(){
        state.pause(this);
    }


}
