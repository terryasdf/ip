public class Event extends ToDo {
    private String startTime;
    private String endTime;

    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        String doneStatus = "[E][" + (isDone ? 'X' : ' ') + "] ";
        String from = " <from: " + startTime + ">";
        String to = " <to: " + endTime + ">";
        return doneStatus + " " + description + from + to;
    }

    public static Event parse(CmdOptArg[] optArgList) {
        checkArgCount(optArgList, 3);

        String description = null;
        String startTime = null;
        String endTime = null;
        for (CmdOptArg optArg : optArgList) {
            if (optArg.isOpt("")) {
                description = optArg.getArg();
            } else if (optArg.isOpt("from")) {
                startTime = optArg.getArg();
            } else if (optArg.isOpt("to")) {
                endTime = optArg.getArg();
            }
        }

        if (description == null) {
            throw new IllegalArgumentException("No description provided.");
        } if (startTime == null) {
            throw new IllegalArgumentException("No start time provided.");
        } if (endTime == null) {
            throw new IllegalArgumentException("No end time provided.");
        }
        return new Event(description, startTime, endTime);
    }
}
