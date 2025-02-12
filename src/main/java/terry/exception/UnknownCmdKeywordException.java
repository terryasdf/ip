package terry.exception;

/**
 * Occurs when a command keyword is not in {@link terry.cmd.CmdKeyword} is read from user input.
 */
public class UnknownCmdKeywordException extends Exception {

    private static final String ERROR_MSG = "Uh oh, unknown keyword: ";
    private final String keyword;

    public UnknownCmdKeywordException(String keyword) {
        super(ERROR_MSG);
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + keyword;
    }
}
