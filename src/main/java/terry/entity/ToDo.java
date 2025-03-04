package terry.entity;

import org.json.JSONObject;
import terry.cmd.CmdOptArg;
import terry.exception.MissingOptArgException;

import java.util.List;

/**
 * Stores todos.
 */
public class ToDo {
    protected String description;
    protected boolean isDone;

    /**
     * Checks if a list of {@link CmdOptArg} has enough number of options.
     * @exception MissingOptArgException when parameter count is less than
     * {@code leastCount}
     * */
    protected static void checkArgCount(List<CmdOptArg> optArgList, int leastCount) throws MissingOptArgException {
        if (optArgList.size() < leastCount) {
            throw new MissingOptArgException(optArgList);
        }
    }

    public ToDo(String description) {
        this.description = description;
        this.isDone = false;
    }

    public ToDo(String description, Boolean isDone) {
        this.description = description;
        this.isDone = isDone;
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

    public JSONObject toJSON() {
        JSONObject json = new JSONObject(this);
        json.put("type", "T");
        return json;
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

     public static ToDo fromJSON(JSONObject json) {
        String description = json.getString("description");
        Boolean isDone = json.getBoolean("done");
        return new ToDo(description, isDone);
    }
}
