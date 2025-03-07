package terry.message;

/**
 * Stores all possible status of a command execution.
 */
public enum ReturnStatus {
    SUCCESS, FAILED, EXCEPTION_CMD_KEYWORD, EXCEPTION_CMD_OPT_ARG, EXCEPTION_IO
}
