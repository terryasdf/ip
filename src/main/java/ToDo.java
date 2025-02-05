public class ToDo {
    private String description;
    private boolean isDone;

    public ToDo() {
        description = "";
        isDone = false;
    }

    public ToDo(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
