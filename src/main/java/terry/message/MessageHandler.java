package terry.message;

/**
 * Responsible for displaying {@link Message}.
 */
public class MessageHandler {
    public static void printGreetingMessage() {
        System.out.println(MessageString.SPLIT_LINE);
        System.out.println(MessageString.GREETING_MSG);
        System.out.println(MessageString.SPLIT_LINE);
    }

    public static void printExitMessage() {
        System.out.println(MessageString.SPLIT_LINE);
        System.out.println(MessageString.EXIT_MSG);
        System.out.println(MessageString.SPLIT_LINE);
    }

    /**
     * Displays {@code info} of a {@link Message}.
     */
    public static void printMessageGeneric(Message msg) {
        System.out.println(MessageString.SPLIT_LINE);
        System.out.println(msg.getInfo());
        System.out.println(MessageString.SPLIT_LINE);
    }
}
