public enum CmdKeyword {
    CMD_LIST, CMD_EXIT, CMD_MARK, CMD_UNMARK, CMD_NONE;

    @Override
    public String toString() {
        return switch (this) {
            case CMD_LIST -> "list";
            case CMD_EXIT -> "bye";
            case CMD_MARK -> "mark";
            case CMD_UNMARK -> "unmark";
            case CMD_NONE -> "";
        };
    }
}
