package terry.command;

/**
 * Stores all available command keywords.
 */
public enum CommandKeyword {
    CMD_TODO,
    CMD_DDL,
    CMD_EVENT,
    CMD_LIST,
    CMD_EXIT,
    CMD_MARK,
    CMD_UNMARK,
    CMD_DELETE,
    CMD_SAVE,
    CMD_LOAD,
    CMD_FIND;

    @Override
    public String toString() {
        return switch (this) {
            case CMD_TODO -> "todo";
            case CMD_DDL -> "ddl";
            case CMD_EVENT -> "event";
            case CMD_LIST -> "list";
            case CMD_EXIT -> "bye";
            case CMD_MARK -> "mark";
            case CMD_UNMARK -> "unmark";
            case CMD_DELETE -> "delete";
            case CMD_SAVE -> "save";
            case CMD_LOAD -> "load";
            case CMD_FIND -> "find";
        };
    }
}
