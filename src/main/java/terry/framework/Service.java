package terry.framework;

import terry.entity.ToDo;

import java.util.ArrayList;

/**
 * Has direct CRUD access to the todo list.
 * <ul><li>Returns unprocessed data</li>
 */

public class Service {

    private static final int MAX_SIZE = 100;
    private static final ArrayList<ToDo> todoList = new ArrayList<>();

    private static void checkIndex(int id) {
        if (id < 0 || id >= todoList.size()) {
            throw new IndexOutOfBoundsException("get: ToDo index out of bound");
        }
    }

    public static ToDo getToDo(int id) {
        checkIndex(id);
        return todoList.get(id);
    }

    public static ToDo[] getToDoList() {
        return todoList.toArray(ToDo[]::new);
    }

    public static void addToDo(ToDo todo) {
        if (todoList.size() == MAX_SIZE) {
            throw new IndexOutOfBoundsException("add: Reached maximum size");
        }
        todoList.add(todo);
    }

    public static ToDo deleteToDo(int id) {
        checkIndex(id);
        return todoList.remove(id);
    }

    public static void markToDo(int id) {
        checkIndex(id);
        todoList.get(id).setDone(true);
    }

    public static void unmarkToDo(int id) {
        checkIndex(id);
        todoList.get(id).setDone(false);
    }
}
