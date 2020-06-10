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

        file = new File(dir, name);

    }

    /**
     * METHODS
     */

    public void createFile() {

        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
    public void deleteFile() {

        file.delete();

    }

    public void writeEntry(String entry){

    }

}