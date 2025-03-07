package terry.message;

/**
 * Stores the status and detailed info of a response.
 *
 * @param status Indicates how a method is executed.
 * @param info   A {@code String} containing detailed information for display.
 */
public record Message(ReturnStatus status, String info) {}
