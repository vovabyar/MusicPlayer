package model.Command;

import model.player.MusicPlayer;

public class PlayCommand extends Command {

    public PlayCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.play();
        return true;
    }
}
