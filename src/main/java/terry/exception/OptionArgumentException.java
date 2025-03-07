package terry.exception;

import terry.command.CommandOptionArgument;

import java.util.List;

/**
 * Occurs when a command due to argument issues.
 */
public class OptionArgumentException extends Exception {

    private static final String MSG = "No can do QAQ. Check your arguments:\n\t";

    public OptionArgumentException(List<CommandOptionArgument> optArgList) {
        super(MSG + CommandOptionArgument.parseString(optArgList));
    }
}
