public enum MsgString {
    SPLIT_LINE, GREETING_MSG, EXIT_MSG, ADD_TODO_MSG, MARK_TODO_MSG, UNMARK_TODO_MSG, CMD_FAILED_MSG, NONE;

    @Override
    public String toString() {
        return switch (this) {
            case SPLIT_LINE -> "____________________________________________________________";
            case GREETING_MSG -> "Ciallo! Terry here.\nWhat can I do for you?";
            case EXIT_MSG -> "Bye. Hope to see you again soon!";
            case ADD_TODO_MSG -> "New task added.";
            case MARK_TODO_MSG -> "Task marked as done. Nice job.";
            case UNMARK_TODO_MSG -> "Task marked as not done.";
            case CMD_FAILED_MSG -> "No can do :(";
            case NONE -> "";
        };
    }
}
