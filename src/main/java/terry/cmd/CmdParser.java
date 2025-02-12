package terry.cmd;

import terry.exception.UnknownCmdKeywordException;

public class CmdParser {

    /**
     * Parses the input line into {@link Cmd}.
     */
    static public Cmd parseCmdInput(String cmdInput) throws UnknownCmdKeywordException {
        String[] cmdArgs = cmdInput.split(" ");
        Cmd cmd = null;

        String keywordString = cmdArgs[0].toLowerCase();
        for (CmdKeyword i : CmdKeyword.values()) {
            if (keywordString.equals(i.toString())) {
                cmd = new Cmd(i);
                break;
            }
        }

        // Not a legit keyword
        if (cmd == null) {
            throw new UnknownCmdKeywordException(keywordString);
        }

        int numWords = cmdArgs.length;
        if (numWords == 1) return cmd;

        CmdOptArg newOptArg = new CmdOptArg();
        StringBuilder arg = new StringBuilder();
        for (int i = 1; i < numWords; ++i) {
            if (!isOpt(cmdArgs[i])) {
                arg.append(cmdArgs[i]).append(' ');
                continue;
            }
            // Contains extra words before a new option
            if (i > 1) {
                newOptArg.setArg(arg.toString().strip());
                cmd.addOptArg(newOptArg);
            }
            newOptArg = new CmdOptArg(cmdArgs[i].substring(1));
            arg = new StringBuilder();
        }

        newOptArg.setArg(arg.toString().strip());
        cmd.addOptArg(newOptArg);
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
