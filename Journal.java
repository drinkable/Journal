// Journal Object. Every entry the user makes will have its own Journal Object.

import java.io.File;
import java.util.Date;

public class Journal {

    /**
     * Elements of a journal entry. The body is stored in a file.
     */

    private JournalWriter ediWriter; // this object will edit and write files
    private String name;
    private String body;
    private Date date;

    /**
     * CONSTRUCTORS
     */

    Journal(String name) {
        this.name = name;
        this.ediWriter = new JournalWriter(name);
    }

    Journal(String name, Date date) {
        this.name = name;
        this.date = date;
        this.ediWriter = new JournalWriter(name);
    }

    /**
     * METHODS
     */

    public void createEntry() {

        ediWriter.createFile();

    }

    public void deleteEntry() {

        ediWriter.deleteFile();

    }

    public String getName() {

        return this.name;

    }

    public void setName(String name) {

        ediWriter.changeName(name);

    }

    public String dateToString() {

        return this.date.toString();

    }

    public void setDate(Date date) {

        this.date = date;

    }

    public String getBody() {

        body = ediWriter.getEntryBody();

        return body;

    }

    public void setBody(String body) {

        this.body = body;

        writeEntry(this.body);

    }

    public void writeEntry(String body) {

        ediWriter.writeEntry(body);

    }

}