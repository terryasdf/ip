package terry.exception;

import terry.message.Message;
import terry.message.MessageHandler;
import terry.message.ReturnStatus;

import java.io.IOException;

/**
 * Handles multiple types of exceptions.
 */
public class ExceptionHandler {

    /**
     * Handles {@link OptionArgumentException} and displays an error {@link Message} with
     * {@code ReturnStatus.EXCEPTION_ARG}.
     */
    public static void handleOptionArgumentException(OptionArgumentException e) {
        Message msg = new Message(ReturnStatus.EXCEPTION_CMD_OPTARG, e.getMessage());
        MessageHandler.printMessageGeneric(msg);
    }

    /**
     * Handles {@link UnknownCommandKeywordException} and displays an error {@link Message} with
     * {@code ReturnStatus.EXCEPTION_UNKNOWN_CMD_KEYWORD}.
     */
    public static void handleUnknownCommandKeywordException(UnknownCommandKeywordException e) {
        Message msg = new Message(ReturnStatus.EXCEPTION_CMD_KEYWORD, e.getMessage());
        MessageHandler.printMessageGeneric(msg);
    }

    /**
     * Handles {@link NumberFormatException} and displays an error {@link Message} with
     * {@code ReturnStatus.FAILED}.
     */
    public static void handleNumberFormatException(NumberFormatException e) {
        Message msg = new Message(ReturnStatus.FAILED, "Your argument is not a number:\n" + e.getMessage());
        MessageHandler.printMessageGeneric(msg);
    }

    /**
     * Handles {@link IOException} and displays an error {@link Message} with
     * {@code ReturnStatus.EXCEPTION_IO}.
     */
    public static void handleIOException(IOException e) {
        Message msg = new Message(ReturnStatus.EXCEPTION_IO, "Cannot access the file:\n" + e.getMessage());
        MessageHandler.printMessageGeneric(msg);
    }

    /**
     * Handles {@link RuntimeException} and displays an error {@link Message} with
     * {@code ReturnStatus.FAILED}.
     */
    public static void handleRuntimeException(RuntimeException e) {
        Message msg = new Message(ReturnStatus.FAILED, "Oh no! Something went wrong:\n" + e.getMessage());
        MessageHandler.printMessageGeneric(msg);
    }
}
