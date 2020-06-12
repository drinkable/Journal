import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JournalWriter {

    /**
     * VARIABLES
     */

    private File file;
    private FileWriter writer;

    final static String dir = "JournalEntries"; // Directory where journal entries will be stored

    /**
     * CONSTRUCTOR
     */

    JournalWriter(String name) {

        name = name.concat(".txt");

        file = new File(dir, name);

      //  initFileWriter();

    }

    /**
     * METHODS
     */

    public void initFileWriter() {

        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createFile() {

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteFile() {

        System.out.println("here");

        file.delete();

    }

    public void writeEntry(String entry) {

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(entry);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}