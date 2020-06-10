import java.io.File;
import java.io.FileWriter;

public class JournalWriter {

    /**
     * VARIABLES
     */

    private static File file;
    private FileWriter writer;

    final static String dir = "JournalEntries"; // Directory where journal entries will be stored

    /**
     * CONSTRUCTOR
     */

    JournalWriter(String name) {

        // name = name.concat(".txt"); // Define the Journal Entry as a text file

        file = new File(dir, name);

        // createFile(name);

        deleteFile();

    }

    /**
     * METHODS
     */

    private static void createFile(String name) {

        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
    public static void deleteFile() {

        file.delete();

    }

}