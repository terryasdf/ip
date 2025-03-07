package terry.exception;

import terry.command.CommandOptionArgument;

import java.util.List;

/**
 * Occurs when a command is missing required options.
 */
public class MissingOptionException extends OptionArgumentException {
    private static final String MSG = "\n\tNot enough arguments.";

    public MissingOptionException(List<CommandOptionArgument> cmd) {
        super(cmd);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + MSG;
    }
}
