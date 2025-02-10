package terry.entity;

import terry.cmd.CmdOptArg;

/**
 * Stores {@link ToDo} with a deadline.
 */
public class Deadline extends ToDo {
    private String ddlTime;

    public Deadline(String description, String ddlTime) {
        super(description);
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

    /**
     * Parses a given list of {@link CmdOptArg} and returns a {@link ToDo} if possible.
     * <ul>Required options:
     *  <li>"": description</li>
     *  <li>"by": deadline</li>
     */
    public static Deadline parse(CmdOptArg[] optArgList) {
        checkArgCount(optArgList, 2);
        String description = null;
        String ddlTime = null;

        for (CmdOptArg optArg : optArgList) {
            if (optArg.isOpt("")) {
                description = optArg.getArg();
            } else if (optArg.isOpt("by")) {
                ddlTime = optArg.getArg();
            }
        }

        /**
         * Parses a given list of {@link CmdOptArg} and returns a {@link ToDo} if possible.
         */
        if (description == null) {
            throw new IllegalArgumentException("No description provided.");
        } if (ddlTime == null) {
            throw new IllegalArgumentException("No deadline provided.");
        }
        return new Deadline(description, ddlTime);
    }
}
