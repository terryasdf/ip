package terry.framework;

import terry.entity.ToDo;

/**
 * Has direct CRUD access to the todo list.
 * <ul><li>Returns unprocessed data</li>
 */

public class Service {
    private static final int MAX_SIZE = 100;
    private static int size = 0;
    private static final ToDo[] todoList = new ToDo[MAX_SIZE];

    public static int getSize() { return size; }

    public static ToDo getToDo(int id) {
//        if (id < 0 || id >= size) return "Invalid task id";
        return todoList[id];
    }

    public static ToDo[] getToDoList() {
        ToDo[] ret = new ToDo[size];
        for (int i = 0; i < size; ++i) {
            ret[i] = todoList[i];
        }
        return ret;
    }

    public static void addToDo(ToDo todo) {
        if (size == MAX_SIZE) {
            throw new IndexOutOfBoundsException("add: ToDo index out of bound");
        }
        todoList[size++] = todo;
    }

    public static void markToDo(int id) {
        if (id < 0 || id >= size) {
            throw new IndexOutOfBoundsException("mark: ToDo index out of bound");
        }
        todoList[id].setDone(true);
    }

    public static void unmarkToDo(int id) {
        if (id < 0 || id >= size) {
            throw new IndexOutOfBoundsException("unmark: ToDo index out of bound");
        }
        todoList[id].setDone(false);
    }
}
