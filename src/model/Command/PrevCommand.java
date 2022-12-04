package model.Command;

import model.player.MusicPlayer;

public class PrevCommand extends Command {

    public PrevCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.prev();
        return true;
    }
}
