public class Deadline extends ToDo {
    private String ddlTime;

    public Deadline(String description, String ddlTime) {
        super(description);
        this.ddlTime = ddlTime;
    }

    public String getDdlTime() {
        return ddlTime;
    }

    public void setDdlTime(String ddlTime) {
        this.ddlTime = ddlTime;
    }
}
