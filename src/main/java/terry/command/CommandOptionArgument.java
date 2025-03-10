package terry.command;

import terry.exception.MissingOptionException;

import java.util.List;

/**
 * Stores option-argument pairs.
 */

public class CommandOptionArgument {

    /**
     * Stores the option, {@code '-'} or {@code '/'} excluded.
     */
    private String opt;
    private String arg;

    /**
     * Constructs a {@code CmdOptArg} with empty {@code opt} and {@code arg}.
     */
    public CommandOptionArgument() {
        this.opt = "";
        this.arg = "";
    }

    /**
     * Constructs a {@code CmdOptArg} with empty {@code arg}.
     */
    public CommandOptionArgument(String opt) {
        this.opt = opt;
        this.arg = "";
    }

    @Override
    public String toString() {
        if (arg.isEmpty()) {
            return opt;
        }
        return opt + ' ' + arg;
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
     * Checks if a {@code String} corresponds to {@code opt}.
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

    /**
     * Parses a {@link List} of arguments into {@code String}.
     * <ul><li>Removes leading and trailing whitespaces</li>
     */
    public static String parseString(List<CommandOptionArgument> optArgList) {
        StringBuilder ret = new StringBuilder();
        for (CommandOptionArgument optArg : optArgList) {
            ret.append(optArg).append(' ');
        }
        return ret.toString().strip();
    }

    /**
     * Checks if a list of {@link CommandOptionArgument} has enough number of options.
     * @exception MissingOptionException when parameter count is less than
     * {@code leastCount}
     * */
    public static void assertLeastOptionCount(List<CommandOptionArgument> optArgList, int leastCount)
            throws MissingOptionException {
        if (optArgList.size() < leastCount) {
            throw new MissingOptionException(optArgList);
        }
    }
}
