package terry.framework;

import org.json.JSONArray;
import terry.entity.ToDo;
import terry.msg.Msg;
import terry.msg.MsgString;
import terry.msg.ReturnStatus;

import java.io.IOException;
import java.util.Arrays;

/**
 * Calls {@link Service} methods.
 * <ul><li>Parses responses into {@link Msg}</li>
 */
public class Controller {

    private static final String SAVE_FILE_PATH = "saved/tasks.json";

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

    public static Msg deleteToDo(int id) {
        ToDo ret = Service.deleteToDo(id);
        String info = generateInfo(MsgString.DELETE_TODO_MSG, ret.toString());
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

    /**
     * Saves the todo list into a json file.
     * @throws IOException Failures of accessing files.
     * */
    public static Msg saveFile() throws IOException {
        ToDo[] todoList = Service.getToDoList();
        JSONArray content = new JSONArray(Arrays.stream(todoList).map(ToDo::toJSON).toList());
        String absolutePath = FileHandler.writeFile(SAVE_FILE_PATH, content);
        String info = generateInfo(MsgString.SAVE_CSV_MSG, absolutePath);
        return new Msg(ReturnStatus.SUCCESS, info);
    }
}
