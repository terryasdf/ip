package terry.entity;

import terry.cmd.CmdOptArg;
import terry.exception.MissingOptArgException;

import java.util.List;

/**
 * Stores todos.
 */
public class ToDo {
    protected String description;
    protected boolean isDone;

    protected static void checkArgCount(List<CmdOptArg> optArgList, int leastCount) throws MissingOptArgException {
        if (optArgList.size() < leastCount) {
            throw new MissingOptArgException(optArgList);
        }
    }

    protected String[] generateParamList() {
        return new String[]{"T", isDone ? "1" : "0", description};
    }

    public ToDo(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        String doneStatus = "[T][" + (isDone ? 'X' : ' ') + "] ";
        return doneStatus + " " + description;
    }

    public String generateCSV() {
        String[] params = generateParamList();
        return String.join(",", params);
    }

    /**
     * Parses a given {@link List} of {@link CmdOptArg} and returns a {@link ToDo} if possible.
     * <ul>Required options:
     *  <li>"": description</li>
     */
    public static ToDo parse(List<CmdOptArg> optArgList) throws MissingOptArgException {
        checkArgCount(optArgList, 1);
        String description = optArgList.iterator().next().getArg();
        if (description.isEmpty()) {
            throw new MissingOptArgException(optArgList);
        }
        return new ToDo(description);
    }
}
