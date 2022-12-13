package designPattern.behavioral.statePattern.example1;

public class PauseState implements State{
    @Override
    public void play(MediaPlayer mediaPlayer) {
        mediaPlayer.setState(new PlayState());
        mediaPlayer.setIcon("paused");
        System.out.printf("Media is playing now and icon %s is enabled", mediaPlayer.getIcon());
        System.out.println();
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {

    }
}
