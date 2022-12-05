;
import model.Command.*;
import model.player.MusicPlayer;

import java.util.Scanner;

/**
 * @author vovabyar
 */
public class Main {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer("songs");

        Thread t = new Thread(new CLI(player));
        t.run();
    }

    public static class CLI implements Runnable {
        private MusicPlayer player;
        private CommandHistory history = new CommandHistory();

        public CLI(MusicPlayer player) {
            this.player = player;
        }

        private void executeCommand(Command command) {
            if (command.execute()) {
                history.push(command);
            }
        }
        @Override
        public void run() {
            boolean isRunning = true;
            Scanner keyboard = new Scanner(System.in);
            String command;
            while (isRunning) {
                System.out.println("------- CURRENT STATUS -------");
                System.out.println(player.status());
                System.out.println("------------------------------");
                System.out.println("Available commands: TURN ON, TURN OFF, PLAY, STOP, NEXT, PREV, STATUS, QUIT");
                System.out.print("Choose command-> ");
                command = keyboard.nextLine().toLowerCase();

                switch (command) {
                    case "play":
                        //player.play();
                        executeCommand(new PlayCommand(player));
                        break;
                    case "stop":
                        executeCommand(new StopCommand(player));
                        break;
                    case "next":
                        executeCommand(new NextCommand(player));
                        break;
                    case "prev":
                        executeCommand(new PrevCommand(player));
                        break;
                    case "turn on":
                        executeCommand(new TurnOnCommand(player));
                        break;
                    case "turn off":
                        executeCommand(new TurnOffCommand(player));
                        break;
                    case "status":
                        executeCommand(new StatusCommand(player));
                        break;
                    case "quit":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid command!");
                }
            }
            System.out.println("!Terminated!");
            if (player.isPlaying()) player.stop();
            System.exit(0);
        }
    }
}
