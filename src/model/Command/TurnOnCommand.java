package model.Command;

import model.player.MusicPlayer;

public class TurnOnCommand extends Command {

    public TurnOnCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        player.turnOn();
        return true;
    }
}
