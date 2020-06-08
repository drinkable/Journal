import java.io.File;
import java.io.FileWriter;

public class JournalWriter {

    /**
     * VARIABLES
     */

    private static File file;
    private FileWriter writer;

    /**
     * CONSTRUCTOR
     */

    JournalWriter(String name) {

        createFile(name);

    }

    /**
     * METHODS
     */

    private static void createFile(String name) {

        String path = "/JournalEntries/" + name;

        file = new File(path);

    }

}