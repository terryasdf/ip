package terry.exception;

import terry.msg.Msg;
import terry.msg.MsgHandler;
import terry.msg.ReturnStatus;

/**
 * Handles multiple types of exceptions.
 */
public class ExceptionHandler {

    /**
     * Handles {@link OptArgException} and displays an error {@link Msg} with
     * {@code ReturnStatus.EXCEPTION_ARG}.
     */
    public static void handleArgException(OptArgException e) {
        Msg msg = new Msg(ReturnStatus.EXCEPTION_CMD_OPTARG, e.getMessage());
        MsgHandler.printMsgGeneric(msg);
    }

    /**
     * Handles {@link UnknownCmdKeywordException} and displays an error {@link Msg} with
     * {@code ReturnStatus.EXCEPTION_UNKNOWN_CMD_KEYWORD}.
     */
    public static void handleUnknownCmdKeywordException(UnknownCmdKeywordException e) {
        Msg msg = new Msg(ReturnStatus.EXCEPTION_CMD_KEYWORD, e.getMessage());
        MsgHandler.printMsgGeneric(msg);
    }

    /**
     * Handles {@link NumberFormatException} and displays an error {@link Msg} with
     * {@code ReturnStatus.FAILED}.
     */
    public static void handleNumberFormatException(NumberFormatException e) {
        Msg msg = new Msg(ReturnStatus.FAILED, "Your argument is not a number:\n" + e.getMessage());
        MsgHandler.printMsgGeneric(msg);
    }

    /**
     * Handles {@link RuntimeException} and displays an error {@link Msg} with
     * {@code ReturnStatus.FAILED}.
     */
    public static void handleRuntimeException(RuntimeException e) {
        Msg msg = new Msg(ReturnStatus.FAILED, "Oh no! Something went wrong:\n" + e.getMessage());
        MsgHandler.printMsgGeneric(msg);
    }
}
