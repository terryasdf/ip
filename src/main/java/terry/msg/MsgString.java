package terry.msg;

/**
 * Stores messages to be displayed.
 */
public enum MsgString {
    SPLIT_LINE, GREETING_MSG, EXIT_MSG, ADD_TODO_MSG,
    LIST_TODO_MSG, LIST_TODO_NONE_MSG, MARK_TODO_MSG,
    UNMARK_TODO_MSG, NONE;

    @Override
    public String toString() {
        return switch (this) {
            case SPLIT_LINE -> "____________________________________________________________";
            case EXIT_MSG -> "Bye. Hope to see you again soon!";
            case ADD_TODO_MSG -> "New task added.";
            case LIST_TODO_MSG -> "Here are your todos.";
            case LIST_TODO_NONE_MSG -> "Oops, I didn't find any todos.";
            case MARK_TODO_MSG -> "Task marked as done. Nice job.";
            case UNMARK_TODO_MSG -> "Task marked as not done.";
            case NONE -> "";
            case GREETING_MSG -> "Ciallo!\n\n" +
                    "          ..............\n" +
                    "      .....###.....###........\n" +
                    "    ...##.....----....-#####-....................\n" +
                    "    ......##+....-##+######++..----...--+++#####......\n" +
                    "      -..#+...--...###-......-------+++---........+###.....\n" +
                    "    ...#..---...##-..---#------------......-.-----.....-##.....\n" +
                    "    ..#----...##.#.-..........-...----------.#+--------.....#-....\n" +
                    "    ..#....###.-.#..-------#+......--.--...##.....---+.-----...#-....\n" +
                    "    ..#.##.##.-#--#.-.--..#..----##.--..##+#--+------#-+------...##-...\n" +
                    "    ..#...-#........---.##----+###...##...#..........#........#-.-.##....\n" +
                    "    ...---#..-..-------#+...#..+..-#.....##.-------.-+.-+++-+--##....#....\n" +
                    "    .....#....--+---.....#########.......#.--+-----.##.----.#...#+---.#....\n" +
                    "    ##...#..-.....----####....+..+####.#-##........#-+#.....#.-..##....#...\n" +
                    "    ....#-----#-----.##....+#####+...##.+..---...-#...#.--.#..--.-##...#...\n" +
                    "    .-.##.-...#......-...#-.......##...-#.---#..-+....#...-#.---..#.#..#...\n" +
                    "    ...#...--..+..--#.--.#...-+--.##....#...#.##......#...#..----.#..#.#..\n" +
                    "    ...-----..####..##...-#++++++#...-----.##...-####-#..#.......-...-#...\n" +
                    "    .--....#..#.....##-.......--.........+#..###......###....---.#...-...\n" +
                    "    ..#+....-..#+...#.....-.#+.....-#--...+.....##......#.------#.....\n" +
                    "    .      ......#####............#...-###........-##..#..---..#....\n" +
                    "            .#+#####....##+.....-#..-....+..............#-.--##....\n" +
                    "            .........-.......--+........-..............-...+.....\n\n" +
                "What can I do for you?";
        };
    }
}
