import java.io.File;
import java.util.Date;

public class Journal {

    /**
     * Elements of a journal entry. The body is strored in a file.
     */

    private File entry;
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

    Journal(String name, Date date){
        this.name = name;
        this.date = date;
    }

    Journal(Date date){
        this.date = date;
    }

}