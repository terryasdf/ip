package terry.cmd;

import java.util.ArrayList;

/**
 * Parses command lines. Contains a {@link CmdKeyword} and a list of {@link CmdOptArg}.
 */
public class Cmd {
    private final CmdKeyword keyword;
    private final ArrayList<CmdOptArg> optArgList;

    /**
     * Constructs a {@code Cmd} with an empty {@code optArgList}.
     */
    public Cmd(CmdKeyword keyword) {
        this.keyword = keyword;
        this.optArgList = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (optArgList.isEmpty()) return keyword.toString();
        return keyword + " " + CmdOptArg.parseString(optArgList);
    }

    public CmdKeyword getKeyword() {
        return keyword;
    }

    public ArrayList<CmdOptArg> getOptArgList() {
        return optArgList;
    }

    public void addOptArg(CmdOptArg optArg) {
        optArgList.add(optArg);
    }
}
