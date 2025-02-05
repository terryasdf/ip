public class CmdParser {
    static public Cmd parseCmdInput(String cmdInput) {
        String[] cmdArgs = cmdInput.split(" ");
        Cmd cmd = new Cmd(CmdKeyword.CMD_NONE);

        if (cmdArgs.length == 0) return cmd;

        String keywordString = cmdArgs[0].toLowerCase();
        for (CmdKeyword i : CmdKeyword.values()) {
            if (keywordString.equals(i.toString())) {
                cmd.setKeyword(i);
                break;
            }
        }

        if (cmd.getKeyword() == CmdKeyword.CMD_NONE) return cmd;

        CmdOptArg newOptArg = null;
        StringBuilder arg = new StringBuilder();
        int numWords = cmdArgs.length;
        for (int i = 1; i < numWords; ++i) {
            if (!isOpt(cmdArgs[i])) {
                arg.append(cmdArgs[i]).append(" ");
                continue;
            }
            if (newOptArg == null) {
                newOptArg = new CmdOptArg(cmdArgs[i]);
                arg = new StringBuilder();
                continue;
            }
            newOptArg.setArg(arg.toString().strip());
            cmd.addOptArg(newOptArg);
            newOptArg = new CmdOptArg(cmdArgs[i]);
            arg = new StringBuilder();
        }

        if (isOpt(cmdArgs[numWords-1])) return cmd;

        if (newOptArg == null) newOptArg = new CmdOptArg("");
        newOptArg.setArg(arg.toString().strip());
        cmd.addOptArg(newOptArg);
        return cmd;
    }

    private static boolean isOpt(String s) {
        return s.startsWith("-") || s.startsWith("/");
    }
}
