import java.util.Scanner;

public class Terry {

    private final static String SPLIT_LINE = "____________________________________________________________";
    private final static String GREETING_MSG = "Hello! I'm Terry!\nWhat can I do for you?";
    private final static String EXIT_MSG = "Bye. Hope to see you again soon!";
    public static final String MARK_TASK_MSG = "Task marked as done. Nice job.";
    public static final String UNMARK_TASK_MSG = "Task marked as not done.";

    private final static int MAX_TASKS = 100;
    private final static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;


    private static void printGreetingMsg() {
        System.out.println(SPLIT_LINE);
        System.out.println(GREETING_MSG);
        System.out.println(SPLIT_LINE);
    }

    private static void printExitMsg() {
        System.out.println(SPLIT_LINE);
        System.out.println(EXIT_MSG);
        System.out.println(SPLIT_LINE);
    }

    private static String getFormattedTaskInfo(int id) {
        if (id < 0 || id >= taskCount) return "";
        return "[" + (tasks[id].isDone() ? 'X' : ' ') + "] " + tasks[id].getDescription();
    }

    private static void printTasks() {
        for (int i = 0; i < taskCount; ++i) {
            System.out.println(Integer.toString(i+1) + "." + getFormattedTaskInfo(i));
        }
    }

    private static void addTask(String description) {
        if (taskCount == MAX_TASKS) return;

        tasks[taskCount++] = new Task(description);
        System.out.println("added: " + description);
    }

    private static void markTask(int id) {
        if (id < 0 || id >= taskCount) return;
        tasks[id].setDone(true);
        System.out.println(MARK_TASK_MSG);
        System.out.println("\t" + getFormattedTaskInfo(id));
    }

    private static void unmarkTask(int id) {
        if (id < 0 || id >= taskCount) return;
        tasks[id].setDone(false);
        System.out.println(UNMARK_TASK_MSG);
        System.out.println("\t" + getFormattedTaskInfo(id));
    }

    private static void readCmd() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String cmd = in.nextLine();
            String[] cmdArgs = cmd.split(" ");
            if (cmdArgs.length == 0) continue;

            System.out.println(SPLIT_LINE);
            if (cmd.equals("bye")) {
                printExitMsg();
                in.close();
                return;
            } else if (cmd.equals("list")) {
                printTasks();
            } else if (cmdArgs[0].equals("mark")) {
                if (cmdArgs.length < 2) continue;
                int id = Integer.parseInt(cmdArgs[1]);
                markTask(id);
            } else if (cmdArgs[0].equals("unmark")) {
                if (cmdArgs.length < 2) continue;
                int id = Integer.parseInt(cmdArgs[1]);
                unmarkTask(id);
            } else {
                addTask(cmd);
            }
            System.out.println(SPLIT_LINE);
        }
    }

    public static void main(String[] args) {
        printGreetingMsg();
        readCmd();
    }
}
