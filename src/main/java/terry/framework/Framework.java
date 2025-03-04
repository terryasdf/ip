package terry.framework;

import terry.cmd.Cmd;
import terry.cmd.CmdKeyword;
import terry.cmd.CmdParser;
import terry.exception.*;
import terry.msg.MsgHandler;

import java.io.IOException;
import java.util.Scanner;

/**
 * The main Terry Chatbot CLI.
 */
public class Framework {

    /**
     * Starts the Terry Chatbot.
     * <ul>
     * <li>Calls {@link CmdRunner} methods for data access</li>
     * <li>Handles CLI-wise exceptions via {@link ExceptionHandler}</li>
     */
    public static void runCLI() {
        MsgHandler.printGreetingMsg();

        // Load from saved JSON at startup
        CmdRunner.executeCmd(new Cmd(CmdKeyword.CMD_LOAD));

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String cmdInput = in.nextLine().strip();
                // Ignore empty input
                if (cmdInput.length() == 0) continue;
                try {
                    Cmd cmd = CmdParser.parseCmdInput(cmdInput);
                    if (CmdRunner.executeCmd(cmd)) continue;
                    return; // Bye and shut down
                } catch (UnknownCmdKeywordException e) {
                    ExceptionHandler.handleUnknownCmdKeywordException(e);
                }
            }
        }
    }
}
