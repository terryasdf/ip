public class Terry {

    private final static String splitLine = "____________________________________________________________";

    private static void printGreetingMsg() {
        String greeting = "Hello! I'm Terry!\nWhat can I do for you?";
        System.out.println(splitLine);
        System.out.println(greeting);
        System.out.println(splitLine);
    }

    private static void printExitMsg() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
        System.out.println(splitLine);
    }

    public static void main(String[] args) {
        printGreetingMsg();
        printExitMsg();
    }
}
