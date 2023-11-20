package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final static String DEFAULT_PATH = System.getProperty("user.home") 
                                        + File.separator + "output.txt";

    private File file;

    public Controller() {
        this.file = new File(DEFAULT_PATH);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getFilePath() {
        return file.getAbsolutePath();
    }

    public void write(String string) throws IOException {
        try (Writer os = new BufferedWriter(new FileWriter(this.file))) {
            os.write(string);
        }
    }
}
