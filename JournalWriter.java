import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JournalWriter {

    /**
     * VARIABLES
     */

    private File file;

    final static String dir = "JournalEntries"; // Directory where journal entries will be stored

    /**
     * CONSTRUCTOR
     */

    JournalWriter(String name) {

        name = name.concat(".txt");

        file = new File(dir, name);

    }

    /**
     * METHODS
     */

    public void createFile() {

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteFile() {

        file.delete();

    }

    public String getEntryBody() {

        String body = "";

        try {

            body = new String(Files.readAllBytes(Paths.get(file.getPath())));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;

    }

    public void changeName(String name) {

        file.renameTo(new File(dir, name.concat(".txt")));

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