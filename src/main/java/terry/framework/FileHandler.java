package terry.framework;

import terry.entity.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles operations related to file IO.
 */
public class FileHandler {

    /**
     * Parses a list of {@link ToDo} to a string in CSV format.
     * @return a {@link String} in CSV format.
     */
    public static String parseToDoList2CSV(ToDo[] todoList) {
        StringBuilder ret = new StringBuilder();
        for (ToDo todo : todoList) {
            ret.append(todo.generateCSV()).append("\n");
        }
        return ret.toString();
    }

    /**
     * Writes a string to a file. Overwrites previous content.
     * @param path The relative path of a file, will be created if not exist.
     * @return The absolute path of the written file.
     * @throws IOException Failures of accessing files.
     */
    public static String writeFile(String path, String content) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(content);
            return f.getAbsolutePath();
        }
    }
}
