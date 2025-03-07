package terry.framework;

import terry.command.Command;
import terry.command.CommandKeyword;
import terry.command.CommandParser;
import terry.exception.ExceptionHandler;
import terry.exception.UnknownCommandKeywordException;
import terry.message.MessageHandler;

import java.util.Scanner;

/**
 * The main Terry Chat Bot CLI.
 */
public class Framework {

    /**
     * Starts the Terry Chat Bot.
     * <ul>
     * <li>Calls {@link CommandRunner} methods for data access</li>
     * <li>Handles CLI-wise exceptions via {@link ExceptionHandler}</li>
     */
    public static void runCLI() {
        MessageHandler.printGreetingMessage();

        // Load from saved JSON at startup
        CommandRunner.executeCommand(new Command(CommandKeyword.CMD_LOAD));

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String cmdInput = in.nextLine().strip();
                if (cmdInput.length() == 0) {
                    continue; // Ignore empty input
                }

                try {
                    Command cmd = CommandParser.parseCommandInput(cmdInput);
                    if (CommandRunner.executeCommand(cmd)) {
                        return; // Shut down if "bye" signal received
                    }
                } catch (UnknownCommandKeywordException e) {
                    ExceptionHandler.handleUnknownCommandKeywordException(e);
                }
            }
        }
    }
}
