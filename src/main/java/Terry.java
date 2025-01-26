import java.util.Scanner;

public class Terry {

    private final static String splitLine = "____________________________________________________________";
    private final static Task[] tasks = new Task[100];
    private static int taskCount = 0;

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
        if (taskCount == 100) return;

        tasks[taskCount++] = new Task(description);
        System.out.println("added: " + description);
    }

    private static void markTask(int id) {
        if (id < 0 || id >= taskCount) return;
        tasks[id].setDone(true);
        System.out.println("Task marked as done. Nice job.");
        System.out.println("\t" + getFormattedTaskInfo(id));
    }

    private static void unmarkTask(int id) {
        if (id < 0 || id >= taskCount) return;
        tasks[id].setDone(false);
        System.out.println("Task marked as not done.");
        System.out.println("\t" + getFormattedTaskInfo(id));
    }

    private static void readCmd() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String cmd = in.nextLine();
            String[] cmdArgs = cmd.split(" ");
            if (cmdArgs.length == 0) continue;

            System.out.println(splitLine);
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
            System.out.println(splitLine);
        }
    }

    public static void main(String[] args) {
        printGreetingMsg();
        readCmd();
    }
}
