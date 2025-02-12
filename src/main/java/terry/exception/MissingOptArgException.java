package terry.exception;

import terry.cmd.CmdOptArg;

import java.util.List;

/**
 * Occurs when a command is missing required options.
 */
public class MissingOptArgException extends OptArgException {
    private static final String MSG = "\n\tNot enough arguments.";

    public MissingOptArgException(List<CmdOptArg> cmd) {
        super(cmd);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + MSG;
    }
}
