package terry.framework;

import terry.entity.ToDo;
import terry.msg.Msg;
import terry.msg.MsgString;
import terry.msg.ReturnStatus;

import java.io.IOException;

/**
 * Calls {@link Service} methods.
 * <ul><li>Parses responses into {@link Msg}</li>
 */
public class Controller {

    private static final String SAVE_CSV_PATH = "saved/tasks.csv";

    private static String generateInfo(MsgString title, String description) {
        return title + "\n\t" + description;
    }

    public static Msg getFormattedToDoInfoList() {
        ToDo[] todoList = Service.getToDoList();

        if (todoList.length == 0) {
            return new Msg(ReturnStatus.SUCCESS, MsgString.LIST_TODO_NONE_MSG.toString());
        }

        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        for (ToDo todo : todoList) {
            ret.append(++cnt).append('.').append(todo).append('\n');
        }
        return new Msg(ReturnStatus.SUCCESS, MsgString.LIST_TODO_MSG + "\n" + ret);
    }

    public static Msg addToDo(ToDo todo) {
        Service.addToDo(todo);
        String info = generateInfo(MsgString.ADD_TODO_MSG, todo.toString());
        return new Msg(ReturnStatus.SUCCESS, info);
    }

    public static Msg markToDo(int id) {
        Service.markToDo(id);
        ToDo moddedToDo = Service.getToDo(id);
        String info = generateInfo(MsgString.MARK_TODO_MSG, moddedToDo.toString());
        return new Msg(ReturnStatus.SUCCESS, info);
    }

    public static Msg unmarkToDo(int id) {
        Service.unmarkToDo(id);
        ToDo moddedToDo = Service.getToDo(id);
        String info = generateInfo(MsgString.UNMARK_TODO_MSG, moddedToDo.toString());
        return new Msg(ReturnStatus.SUCCESS, info);
    }

    public static Msg saveCSV() throws IOException {
        ToDo[] todoList = Service.getToDoList();
        String content = FileHandler.parseToDoList2CSV(todoList);
        String absolutePath = FileHandler.writeFile(SAVE_CSV_PATH, content);
        String info = generateInfo(MsgString.SAVE_CSV_MSG, absolutePath);
        return new Msg(ReturnStatus.SUCCESS, info);
    }
}
