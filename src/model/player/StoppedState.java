package model.player;

import model.Song;

public class StoppedState extends MusicPlayerState {

    public StoppedState(MusicPlayer player) {
        super(player);
    }

    @Override
    public void play() {
        player.startPlayback();
        player.changeState(new PlayingState(player));
    }

    @Override
    public void stop() {}

    @Override
    public void next() {
        Song next = player.getPlaylist().getNext();
        player.initPlayer(next);
    }

    @Override
    public void prev() {
        Song prev = player.getPlaylist().getNext();
        player.initPlayer(prev);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {
        player.disposePlayer();
        player.changeState(new OffState(player));
    }

    @Override
    public String status() {
        return "Stopped:" + player.getPlaylist().getCurrent().toString();
    }
}