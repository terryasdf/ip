package terry.exception;

import terry.cmd.CmdOptArg;

import java.util.List;

/**
 * Occurs when an argument of a command is invalid.
 */
public class InvalidOptArgException extends OptArgException {

    private static final String MSG = "\n\tInvalid arguments.";
    public InvalidOptArgException(List<CmdOptArg> optArgList) {
        super(optArgList);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + MSG;
    }
}
