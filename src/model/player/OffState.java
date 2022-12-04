package model.player;

public class OffState extends MusicPlayerState {
    public OffState(MusicPlayer player) {
        super(player);
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void next() {

    }

    @Override
    public void prev() {

    }

    @Override
    public void turnOn() {
        player.initPlayer(player.getPlaylist().getCurrent());
        player.changeState(new StoppedState(player));
    }

    @Override
    public void turnOff() {

    }

    @Override
    public String status() {
        return "Turned Off";
    }
}