package designPattern.behavioral.statePattern.example1;

public class PlayState implements State{
    @Override
    public void play(MediaPlayer mediaPlayer) {

    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        mediaPlayer.setState(new PauseState());
        mediaPlayer.setIcon("playing");
        System.out.printf("Media is paused now and icon %s is enabled", mediaPlayer.getIcon());
        System.out.println();
    }
}
