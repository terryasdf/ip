package terry.msg;

/**
 * Stores messages to be displayed.
 */
public enum MsgString {
    SPLIT_LINE,
    GREETING_MSG,
    EXIT_MSG,
    ADD_TODO_MSG,
    DELETE_TODO_MSG,
    LIST_TODO_MSG,
    LIST_TODO_NONE_MSG,
    MARK_TODO_MSG,
    UNMARK_TODO_MSG,
    SAVE_FILE_MSG,
    LOAD_FILE_MSG,
    NONE;

    @Override
    public String toString() {
        return switch (this) {
            case SPLIT_LINE -> "____________________________________________________________";
            case EXIT_MSG -> "Bye. Hope to see you again soon!";
            case ADD_TODO_MSG -> "New task added.";
            case DELETE_TODO_MSG -> "Removed the task for you.";
            case LIST_TODO_MSG -> "Here are your todos.";
            case LIST_TODO_NONE_MSG -> "Oops, I didn't find any todos.";
            case MARK_TODO_MSG -> "Task marked as done. Nice job.";
            case UNMARK_TODO_MSG -> "Task marked as not done.";
            case SAVE_FILE_MSG -> "You can now access your saved tasks!";
            case LOAD_FILE_MSG -> "Saved tasks successfully loaded.";
            case NONE -> "";
            case GREETING_MSG -> """
                    Ciallo!

                               ###.....###
                           ##.....----....-#####-
                              ##+....-##+######++..----...--+++#####
                          -..#+...--...###-......-------+++---........+###
                           #..---...##-..---#------------......-.-----.....-##
                          #----...##.#.-..........-...----------.#+--------.....#-
                          #....###.-.#..-------#+......--.--...##.....---+.-----...#-
                          #.## ##.-#--#.-.--..#..----##.--..##+#--+------#-+------...##-
                          #    #........---.##----+###...##...#..........#........#-.-.##
                              #..-..-------#+...#..+..-#.....##.-------.-+.-+++-+--##....#
                             #....--+---.....#########.......#.--+-----.##.----.#...#+---.#
                             #..-.....----####....+..+####.#-##........#-+#.....#.-..##....#
                            #-----#-----.##....+#####+...##.+..---...-#...#.--.#..--.-##...#
                         - ##.-...#......-...#-.......##...-#.---#..-+....#...-#.---..# #..#
                         ..#...--..+..--#.--.#...-+--.##....#...#.##......#...#..----.#  #.#
                         ..-----..####..##...-#++++++#...-----.##...-####-#..#.......-   -#
                         --....#..#.....##-.......--.........+#..###......###....---.#   -
                         .#+....-..#+...#.....-.#+.....-#--...+.....##......#.------#
                         ............#####............#...-###........-##..#..---..#
                         ........#+#####....##+.....-#..-....+..............#-.--##
                         ................-.......--+........-..............-...+

                    What can I do for you?""";
        };
    }
}
