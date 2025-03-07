package terry.framework;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import terry.entity.Deadline;
import terry.entity.Event;
import terry.entity.ToDo;
import terry.exception.ExceptionHandler;
import terry.message.Message;
import terry.message.MessageString;
import terry.message.ReturnStatus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Calls {@link Service} methods.
 * <ul><li>Parses responses into {@link Message}</li>
 */
public class Controller {

    private static final String SAVE_FILE_PATH = "saved/tasks.json";

    private static String generateInfo(MessageString title, String description) {
        return title + "\n\t" + description;
    }

    private static String generateFormattedToDoInfoList(List<ToDo> todoList) {
        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        for (ToDo todo : todoList) {
            ret.append(++cnt).append('.').append(todo).append('\n');
        }
        return ret.toString();
    }

    public static Message getToDoList() {
        ArrayList<ToDo> todoList = Service.getToDoList();
        if (todoList.size() == 0) {
            return new Message(ReturnStatus.SUCCESS, MessageString.LIST_TODO_NONE_MSG.toString());
        }

        String content = generateFormattedToDoInfoList(todoList);
        return new Message(ReturnStatus.SUCCESS, MessageString.LIST_TODO_MSG + "\n" + content);
    }

    public static Message addToDo(ToDo todo) {
        Service.addToDo(todo);
        String info = generateInfo(MessageString.ADD_TODO_MSG, todo.toString());
        return new Message(ReturnStatus.SUCCESS, info);
    }

    public static Message deleteToDo(int id) {
        ToDo ret = Service.deleteToDo(id);
        String info = generateInfo(MessageString.DELETE_TODO_MSG, ret.toString());
        return new Message(ReturnStatus.SUCCESS, info);
    }

    public static Message markToDo(int id) {
        Service.markToDo(id);
        ToDo moddedToDo = Service.getToDo(id);
        String info = generateInfo(MessageString.MARK_TODO_MSG, moddedToDo.toString());
        return new Message(ReturnStatus.SUCCESS, info);
    }

    public static Message unmarkToDo(int id) {
        Service.unmarkToDo(id);
        ToDo moddedToDo = Service.getToDo(id);
        String info = generateInfo(MessageString.UNMARK_TODO_MSG, moddedToDo.toString());
        return new Message(ReturnStatus.SUCCESS, info);
    }

    public static Message findToDoByKeyword(String keyword) {
        ArrayList<ToDo> todoList = Service.findToDoByKeyword(keyword);
        if (todoList.size() == 0) {
            return new Message(ReturnStatus.SUCCESS, MessageString.LIST_TODO_NONE_MSG.toString());
        }

        String content = generateFormattedToDoInfoList(todoList);
        return new Message(ReturnStatus.SUCCESS, MessageString.LIST_TODO_MSG + "\n" + content);
    }

    /**
     * Loads a JSON array from the file and parses to the todo list.
     * @throws FileNotFoundException Failure of finding the specified file.
     * */
    public static Message readFile() throws FileNotFoundException {
        JSONArray jsonArray = FileHandler.readFile(SAVE_FILE_PATH);
        int len = jsonArray.length();
        for (int i = 0; i < len; ++i) {
            try {
                JSONObject json = jsonArray.getJSONObject(i);
                String todoType = json.getString("type");
                ToDo todo = switch (todoType) {
                    case "T" -> ToDo.fromJSON(json);
                    case "D" -> Deadline.fromJSON(json);
                    case "E" -> Event.fromJSON(json);
                    default -> throw new JSONException("Unrecognized todo type in your save: " + todoType);
                };
                Service.addToDo(todo);
            } catch (JSONException e) {
                ExceptionHandler.handleRuntimeException(e);
            }
        }
        return new Message(ReturnStatus.SUCCESS, MessageString.LOAD_FILE_MSG.toString());
    }

    /**
     * Saves the todo list into a JSON file.
     * @throws IOException Failures of accessing files.
     * */
    public static Message saveFile() throws IOException {
        ArrayList<ToDo> todoList = Service.getToDoList();
        JSONArray content = new JSONArray(todoList.stream().map(ToDo::toJSON).toList());
        String absolutePath = FileHandler.writeFile(SAVE_FILE_PATH, content);
        String info = generateInfo(MessageString.SAVE_FILE_MSG, absolutePath);
        return new Message(ReturnStatus.SUCCESS, info);
    }
}
