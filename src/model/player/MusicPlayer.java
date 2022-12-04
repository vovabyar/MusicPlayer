package model.player;

import model.Playlist;
import model.Song;

import javax.media.*;
import java.io.IOException;

public class MusicPlayer {

    private Player javaMediaPlayer;
    private Playlist playlist;

    private MusicPlayerState state;

    public MusicPlayer(String folderPath) {
        playlist = new Playlist();
        try {
            playlist.readFromFolder(folderPath);
            state = new OffState(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        state.play();
    }

    public void stop() {
        state.stop();
    }

    public void next() {
        state.next();
    }

    public void prev() {
        state.prev();
    }

    public void turnOn() { state.turnOn(); }

    public void turnOff() { state.turnOff(); }

    public String status() {
        return state.status();
    }

    public boolean isPlaying() {
        return state instanceof PlayingState;
    }

    protected void changeState(MusicPlayerState s) {
        this.state = s;
    }

    protected Playlist getPlaylist() {
        return playlist;
    }

    protected void initPlayer(Song song) {
        try {
            javaMediaPlayer = Manager.createRealizedPlayer(playlist.getCurrent().getUnderlyingFile().toURI().toURL());
        } catch (IOException | CannotRealizeException | NoPlayerException e) {
            e.printStackTrace();
        }
    }

    protected void disposePlayer() {
        javaMediaPlayer.stop();
        javaMediaPlayer.close();
    }

    protected void startPlayback() {
        javaMediaPlayer.start();
    }

    protected void stopPlayback() {
        javaMediaPlayer.stop();
    }

    protected void skip10seconds() {
        Time mediaTime = javaMediaPlayer.getMediaTime();
        Time skipTime = new Time(mediaTime.getSeconds() + 10);
        javaMediaPlayer.setMediaTime(skipTime);
    }

    protected void rewind10seconds() {
        Time mediaTime = javaMediaPlayer.getMediaTime();
        Time skipTime = new Time(mediaTime.getSeconds() - 10);
        javaMediaPlayer.setMediaTime(skipTime);
    }

    protected Time getMediaTime() {
        return javaMediaPlayer.getMediaTime();
    }

    protected Time getDuration() {
        return javaMediaPlayer.getDuration();
    }

    public static String timeToHuman(Time t) {
        int totalSeconds = (int)t.getSeconds();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

}