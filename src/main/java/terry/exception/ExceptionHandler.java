package terry.exception;

import terry.msg.Msg;
import terry.msg.ReturnStatus;

/**
 * Handles multiple types of exceptions.
 */
public class ExceptionHandler {

    /**
     * Handles {@link Exception} and returns an error {@link Msg} with {@code ReturnStatus.FAILED}.
     */
    public static Msg handleUnknownCmdKeywordException (UnknownCmdKeywordException e) {
        return new Msg(ReturnStatus.UNKNOWN_CMD_KEYWORD, e.getMessage());
    }

    /**
     * Handles {@link Exception} and returns an error {@link Msg} with {@code ReturnStatus.FAILED}.
     */
    public static Msg handleException(Exception e) {
        return new Msg(ReturnStatus.FAILED, e.getMessage());
    }
}
