package terry.framework;

import terry.exception.*;
import terry.msg.MsgHandler;

import java.io.IOException;
import java.util.Scanner;

/**
 * The main Terry Chatbot CLI.
 * <ul>
 * <li>Calls {@link CmdRunner} methods for data access</li>
 * <li>Handles exceptions via {@link ExceptionHandler}</li>
 */
public class Framework {

    /**
     * Starts the Terry Chatbot.
     */
    public static void runCLI() {
        MsgHandler.printGreetingMsg();
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String cmdInput = in.nextLine().strip();
                // Ignore empty input
                if (cmdInput.length() == 0) continue;
                // Execute command
                if (CmdRunner.processAndExecuteCmd(cmdInput)) continue;
                // Bye and shut down
                in.close();
                return;
            } catch (OptArgException e) {
                ExceptionHandler.handleArgException(e);
            } catch (UnknownCmdKeywordException e) {
                ExceptionHandler.handleUnknownCmdKeywordException(e);
            } catch (NumberFormatException e) {
                ExceptionHandler.handleNumberFormatException(e);
            } catch (IOException e) {
                ExceptionHandler.handleIOException(e);
            } catch (RuntimeException e) {
                ExceptionHandler.handleRuntimeException(e);
            }
        }
    }
}
