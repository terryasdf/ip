package terry.framework;

import terry.command.Command;
import terry.command.CommandKeyword;
import terry.command.CommandParser;
import terry.exception.*;
import terry.message.MessageHandler;

import java.util.Scanner;

/**
 * The main Terry Chatbot CLI.
 */
public class Framework {

    /**
     * Starts the Terry Chatbot.
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
                // Ignore empty input
                if (cmdInput.length() == 0) continue;
                try {
                    Command cmd = CommandParser.parseCommandInput(cmdInput);
                    if (CommandRunner.executeCommand(cmd)) continue;
                    return; // Bye and shut down
                } catch (UnknownCommandKeywordException e) {
                    ExceptionHandler.handleUnknownCommandKeywordException(e);
                }
            }
        }
    }
}
