package terry.msg;

/**
 * Stores the status and detailed info of a response.
 */
public class Msg {

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
     * Constructs a {@link Msg} with empty {@code info}.
     */
    public Msg(ReturnStatus status) {
        this.status = status;
        this.info = "";
    }

    public Msg(ReturnStatus status, String info) {
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
