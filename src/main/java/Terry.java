import java.util.Scanner;

public class Terry {

    private final static String splitLine = "____________________________________________________________";
    private final static String[] cmdList = new String[100];
    private static int cmdCount = 0;

    private static void printGreetingMsg() {
        String greeting = "Hello! I'm Terry!\nWhat can I do for you?";
        System.out.println(splitLine);
        System.out.println(greeting);
        System.out.println(splitLine);
    }

    private static void printExitMsg() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(splitLine);
        System.out.println(bye);
        System.out.println(splitLine);
    }

    private static void printCmdList() {
        for (int i = 0; i < cmdCount; ++i) {
            System.out.println(Integer.toString(i+1) + ". " + cmdList[i]);
        }
    }

    private static void addToCmdList(String cmd) {
        if (cmdCount == 100) return;

        cmdList[cmdCount++] = cmd;
        System.out.println("added: " + cmd);
    }

    private static void readCmd() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String cmd = in.nextLine();

            if (cmd.equals("bye")) {
                printExitMsg();
                in.close();
                return;
            } else if (cmd.equals("list")) {
                System.out.println(splitLine);
                printCmdList();
                System.out.println(splitLine);
            } else {
                System.out.println(splitLine);
                addToCmdList(cmd);
                System.out.println(splitLine);
            }
        }
    }

    public static void main(String[] args) {
        printGreetingMsg();
        readCmd();
    }
}
