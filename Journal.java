// Journal Object. Every entry the user makes will have its own Journal Object.

import java.io.File;
import java.util.Date;

public class Journal {

    /**
     * Elements of a journal entry. The body is strored in a file.
     */

    private JournalWriter ediWriter; // this object will edit and write files
    private String name;
    private String body;
    private Date date;

    /**
     * CONSTRUCTORS
     */

    Journal() {

    }

    Journal(String name) {
        this.name = name;
    }

    Journal(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    Journal(Date date) {
        this.date = date;
    }

    /**
     * METHODS
     */

    public void createFile() {
        ediWriter = new JournalWriter(name);
    }

}