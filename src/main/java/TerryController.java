public class TerryController {
    private static final int MAX_SIZE = 100;
    private static int size = 0;
    private static final ToDo[] todoList = new ToDo[MAX_SIZE];

    public static int getSize() { return size; }

    public static String getFormattedToDoInfo(int id) {
        if (id < 0 || id >= size) return "Invalid task id";
        String doneStatus = "[" + (todoList[id].isDone() ? 'X' : ' ') + "] ";
        return doneStatus + todoList[id].getDescription();
    }

    public static String[] getFormattedToDoInfoList() {
        String[] ret = new String[size];
        for (int i = 0; i < size; ++i) {
            ret[i] = getFormattedToDoInfo(i);
        }
        return ret;
    }


    public static boolean addToDo(ToDo todo) {
        if (size == MAX_SIZE) return true;
        todoList[size++] = todo;
        return false;
    }

    public static boolean addToDo(String description) {
        if (size == MAX_SIZE) return true;
        todoList[size++] = new ToDo(description);
        return false;
    }

    public static boolean markToDo(int id) {
        if (id < 0 || id >= size) return true;
        todoList[id].setDone(true);
        return false;
    }

    public static boolean unmarkToDo(int id) {
        if (id < 0 || id >= size) return true;
        todoList[id].setDone(false);
        return false;
    }
}
