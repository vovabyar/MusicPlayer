package model.Command;

import model.player.MusicPlayer;

public class StopCommand extends Command {

    public StopCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.stop();
        return true;
    }
}
