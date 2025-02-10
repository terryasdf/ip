package terry.cmd;

/**
 * Stores option-argument pairs.
 */

public class CmdOptArg {

    /**
     * Stores the option, {@code '-'} or {@code '/'} excluded.
     */
    private String opt;
    private String arg;

    /**
     * Constructs a {@code CmdOptArg} with empty {@code opt} and {@code arg}.
     */
    public CmdOptArg() {
        this.opt = "";
        this.arg = "";
    }

    /**
     * Constructs a {@code CmdOptArg} with empty {@code arg}.
     */
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

    /**
     * Check if a {@code String} corresponds to {@code opt}.
     * <p>Returns {@code true} if the given option is a prefix of {@code opt}.
     * <ul>
     *     <li>If {@code opt} is empty and the given one is also empty, return {@code true}</li>
     *     <li>Otherwise return {@code false} for empty given strings.</li>
     */
    public boolean isOpt(String opt) {
        if (opt.isEmpty()) {
            return this.opt.isEmpty();
        }
        return opt.startsWith(this.opt);
    }

    /**
     * Parses the argument into {@code int}.
     */
    public int parseInt() {
        return Integer.parseInt(arg);
    }
}
