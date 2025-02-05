public class CmdOptArg {
    private String opt;
    private String arg;

    public CmdOptArg() {
        this.opt = "";
        this.arg = "";
    }

    public CmdOptArg(String opt) {
        this.opt = opt;
        this.arg = "";
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}
