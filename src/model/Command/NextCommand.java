package model.Command;

import model.player.MusicPlayer;

public class NextCommand extends Command {

    public NextCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.next();
        return true;
    }
}
