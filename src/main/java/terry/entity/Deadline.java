package terry.entity;

import org.json.JSONObject;
import terry.command.CommandOptionArgument;
import terry.exception.MissingOptionException;

import java.util.List;

/**
 * Stores {@link ToDo} with a deadline.
 */
public class Deadline extends ToDo {
    private String ddlTime;

    public Deadline(String description, String ddlTime) {
        super(description);
        this.ddlTime = ddlTime;
    }

    public Deadline(String description, Boolean isDone, String ddlTime) {
        super(description, isDone);
        this.ddlTime = ddlTime;
    }

    public String getDdlTime() {
        return ddlTime;
    }

    public void setDdlTime(String ddlTime) {
        this.ddlTime = ddlTime;
    }

    @Override
    public String toString() {
        String doneStatus = "[D][" + (isDone ? 'X' : ' ') + "] ";
        String by = " <by: " + ddlTime + ">";
        return doneStatus + " " + description + by;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject(this);
        json.put("type", "D");
        return json;
    }

    /**
     * Parses a given list of {@link CommandOptionArgument} and returns a {@link ToDo} if possible.
     * <ul>Required options:
     *  <li>"": description</li>
     *  <li>"by": deadline</li>
     */
    public static Deadline parse(List<CommandOptionArgument> optArgList) throws MissingOptionException {
        checkArgCount(optArgList, 2);
        String description = null;
        String ddlTime = null;

        for (CommandOptionArgument optArg : optArgList) {
            if (optArg.isOpt("")) {
                description = optArg.getArg();
            } else if (optArg.isOpt("by")) {
                ddlTime = optArg.getArg();
            }
        }

        if (description == null) {
            throw new MissingOptionException(optArgList);
        } if (ddlTime == null) {
            throw new MissingOptionException(optArgList);
        }
        return new Deadline(description, ddlTime);
    }

    public static Deadline fromJSON(JSONObject json) {
        String description = json.getString("description");
        Boolean isDone = json.getBoolean("done");
        String ddlTime = json.getString("ddlTime");
        return new Deadline(description, isDone, ddlTime);
    }
}
