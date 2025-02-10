package terry.entity;

import terry.cmd.CmdOptArg;

/**
 * Stores todos.
 */
public class ToDo {
    protected String description;
    protected boolean isDone;

    protected static void checkArgCount(CmdOptArg[] optArgList, int leastCount) {
        if (optArgList.length < leastCount) {
            throw new IllegalArgumentException("Argument not matching");
        }
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

    /**
     * Parses a given list of {@link CmdOptArg} and returns a {@link ToDo} if possible.
     * <ul>Required options:
     *  <li>"": description</li>
     */
    public static ToDo parse(CmdOptArg[] optArgList) {
        checkArgCount(optArgList, 1);
        String description = optArgList[0].getArg();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("No description provided.");
        }
        return new ToDo(description);
    }
}
