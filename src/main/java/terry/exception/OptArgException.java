package terry.exception;

import terry.cmd.CmdOptArg;

import java.util.List;

/**
 * Occurs when a command due to argument issues.
 */
public class OptArgException extends Exception {

    private static final String MSG = "No can do QAQ. Check your arguments:\n\t";

    public OptArgException(List<CmdOptArg> optArgList) {
        super(MSG + CmdOptArg.parseString(optArgList));
    }
}
