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

    public static Deadline parse(CmdOptArg[] optArgList) {
        checkArgCount(optArgList, 2);
        String description = "A task";
        String ddlTime = null;

        for (CmdOptArg optArg : optArgList) {
            if (optArg.isOpt("")) {
                description = optArg.getArg();
            } else if (optArg.isOpt("by")) {
                ddlTime = optArg.getArg();
            }
        }

        if (ddlTime == null) {
            throw new IllegalArgumentException("No deadline provided.");
        }
        return new Deadline(description, ddlTime);
    }
}
