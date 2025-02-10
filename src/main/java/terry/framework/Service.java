package terry.framework;

import terry.entity.ToDo;

/**
 * Has direct CRUD access to the todo list.
 */

public class Service {
    private static final int MAX_SIZE = 100;
    private static int size = 0;
    private static final ToDo[] todoList = new ToDo[MAX_SIZE];

    public static int getSize() { return size; }

    public static String getFormattedToDoInfo(int id) {
        if (id < 0 || id >= size) return "Invalid task id";
        return todoList[id].toString();
    }

    public static String[] getFormattedToDoInfoList() {
        String[] ret = new String[size];
        for (int i = 0; i < size; ++i) {
            ret[i] = todoList[i].toString();
        }
        return ret;
    }

    public static boolean addToDo(ToDo todo) {
        if (size == MAX_SIZE) return true;
        todoList[size++] = todo;
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
