package terry.exception;

import terry.command.CommandKeyword;

/**
 * Occurs when a command keyword is not in {@link CommandKeyword} is read from user input.
 */
public class UnknownCommandKeywordException extends Exception {

    private static final String MSG = "Uh oh, unknown keyword: ";
    private final String keyword;

    public UnknownCommandKeywordException(String keyword) {
        super(MSG);
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
