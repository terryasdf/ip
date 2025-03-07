package terry.framework;

import org.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles operations related to file IO.
 */
public class FileHandler {

    /**
     * Reads and load a {@link JSONArray} from a file.
     * @param path The relative path of a file.
     * @return A parsed {@link JSONArray}.
     * @throws FileNotFoundException Failure of finding the specified file.
     */
    public static JSONArray readFile(String path) throws FileNotFoundException {
        File f = new File(path);
        try (Scanner s = new Scanner(f)) {
            StringBuilder content = new StringBuilder();
            while (s.hasNext()) {
                content.append(s.nextLine());
            }
            return new JSONArray(content.toString());
        }
    }

    /**
     * Writes JSON to a file. Overwrites previous content.
     * @param path The relative path of a file, will be created if not exist.
     * @return The absolute path of the written file.
     * @throws IOException Failures of accessing files.
     */
    public static String writeFile(String path, JSONArray jsonArray) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(jsonArray.toString(4));
            return f.getAbsolutePath();
        }
    }
}
