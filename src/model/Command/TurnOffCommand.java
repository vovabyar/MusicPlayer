package model.Command;

import model.player.MusicPlayer;

public class TurnOffCommand extends Command {

    public TurnOffCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.turnOff();
        return true;
    }
}
