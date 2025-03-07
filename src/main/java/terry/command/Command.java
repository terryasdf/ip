package terry.command;

import java.util.ArrayList;

/**
 * Parses command lines. Contains a {@link CommandKeyword} and a list of {@link CommandOptionArgument}.
 */
public class Command {
    private final CommandKeyword keyword;
    private final ArrayList<CommandOptionArgument> optArgList;

    /**
     * Constructs a {@code Cmd} with an empty {@code optArgList}.
     */
    public Command(CommandKeyword keyword) {
        this.keyword = keyword;
        this.optArgList = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (optArgList.isEmpty()) {
            return keyword.toString();
        }
        return keyword + " " + CommandOptionArgument.parseString(optArgList);
    }

    public CommandKeyword getKeyword() {
        return keyword;
    }

    public ArrayList<CommandOptionArgument> getOptionArgumentList() {
        return optArgList;
    }

    public void addOptionArgument(CommandOptionArgument optArg) {
        optArgList.add(optArg);
    }
}
