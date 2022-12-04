package model.Command;

import model.player.MusicPlayer;

public class StatusCommand extends Command {

    public StatusCommand(MusicPlayer player) {
        super(player);
    }

    @Override
    public boolean execute() {
        System.out.println(player.status());
        return true;
    }
}
