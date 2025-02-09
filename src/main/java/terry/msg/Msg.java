package terry.msg;

public class Msg {
    private final ReturnStatus status;
    private final String info;

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
