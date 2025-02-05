import java.util.ArrayList;

public class Cmd {
    private CmdKeyword keyword;
    private final ArrayList<CmdOptArg> optArgList;

    public Cmd(CmdKeyword keyword) {
        this.keyword = keyword;
        this.optArgList = new ArrayList<>();
    }

    public CmdKeyword getKeyword() {
        return keyword;
    }

    public void setKeyword(CmdKeyword keyword) {
        this.keyword = keyword;
    }

    public ArrayList<CmdOptArg> getOptArgList() {
        return optArgList;
    }

    public void addOptArg(CmdOptArg optArg) {
        optArgList.add(optArg);
    }
}
