package terry.message;

/**
 * Stores the status and detailed info of a response.
 */
public class Message {

    /**
     * Indicates how a method is executed.
     * @see ReturnStatus
     */
    private final ReturnStatus status;

    /**
     * A {@code String} containing detailed information for display.
     */
    private final String info;

    /**
     * Constructs a {@link Message} with empty {@code info}.
     */
    public Message(ReturnStatus status) {
        this.status = status;
        this.info = "";
    }

    public Message(ReturnStatus status, String info) {
        this.status = status;
        this.info = info;
    }

    public ReturnStatus getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }
}
