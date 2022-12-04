package model.player;

public abstract class MusicPlayerState {

    protected MusicPlayer player;

    public MusicPlayerState(MusicPlayer player) {
        this.player = player;
    }

    public abstract void play();
    public abstract void stop();
    public abstract void next();
    public abstract void prev();
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract String status();

}