package terry.command;

import terry.exception.UnknownCommandKeywordException;

public class CommandParser {

    /**
     * Parses the input line into {@link Command}.
     */
    public static Command parseCommandInput(String cmdInput) throws UnknownCommandKeywordException {
        String[] cmdArgs = cmdInput.split(" ");
        Command cmd = null;

        String keywordString = cmdArgs[0].toLowerCase();
        for (CommandKeyword i : CommandKeyword.values()) {
            if (keywordString.equals(i.toString())) {
                cmd = new Command(i);
                break;
            }
        }

        // Not a legit keyword
        if (cmd == null) {
            throw new UnknownCommandKeywordException(keywordString);
        }

        int numWords = cmdArgs.length;
        if (numWords == 1) {
            return cmd;
        }

        CommandOptionArgument newOptArg = new CommandOptionArgument();
        StringBuilder arg = new StringBuilder();
        for (int i = 1; i < numWords; ++i) {
            if (!isOpt(cmdArgs[i])) {
                arg.append(cmdArgs[i]).append(' ');
                continue;
            }
            // Contains extra words before a new option
            if (i > 1) {
                newOptArg.setArg(arg.toString().strip());
                cmd.addOptionArgument(newOptArg);
            }
            newOptArg = new CommandOptionArgument(cmdArgs[i].substring(1));
            arg = new StringBuilder();
        }

        newOptArg.setArg(arg.toString().strip());
        cmd.addOptionArgument(newOptArg);
        return cmd;
    }

    /**
     * Checks if a {@code String} is an option expression.
     * <p>Returns {@code true} if the string starts with {@code '-'} or {@code '/'}.
     */
    private static boolean isOpt(String s) {
        return s.startsWith("-") || s.startsWith("/");
    }
}
