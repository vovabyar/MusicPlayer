package model.Command;

import model.player.MusicPlayer;

public abstract class Command {
    public MusicPlayer player;
    private String backup;

    Command(MusicPlayer player) {
        this.player = player;
    }

    void backup() {
        //backup = editor.textField.getText();
    }

    public void undo() {
        //editor.textField.setText(backup);
    }

    public abstract boolean execute();
}