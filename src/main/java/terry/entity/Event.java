package terry.entity;

import terry.cmd.CmdOptArg;
import terry.exception.MissingOptArgException;

import java.util.List;

/**
 * Stores {@link ToDo} with a start time and an end time.
 */
public class Event extends ToDo {
    private String startTime;
    private String endTime;

    @Override
    protected String[] generateParamList() {
        return new String[]{"E", isDone ? "1" : "0", description, startTime, endTime};
    }

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

    /**
     * Parses a given list of {@link CmdOptArg} and returns a {@link ToDo} if possible.
     * <ul>Required options:
     *  <li>"": description</li>
     *  <li>"from": start time</li>
     *  <li>"to": end time</li>
     */
    public static Event parse(List<CmdOptArg> optArgList) throws MissingOptArgException {
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
            throw new MissingOptArgException(optArgList);
        } if (startTime == null) {
            throw new MissingOptArgException(optArgList);
        } if (endTime == null) {
            throw new MissingOptArgException(optArgList);
        }
        return new Event(description, startTime, endTime);
    }
}
