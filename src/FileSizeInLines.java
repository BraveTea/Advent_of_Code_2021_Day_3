import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSizeInLines {

    private int fileSize;
    private Scanner fileScanner;

    public FileSizeInLines(File file) throws FileNotFoundException {
        fileScanner = new Scanner(file);
        while (fileScanner.hasNext()){
            fileScanner.next();
            fileSize++;
        }
        fileScanner.close();
    }


    public int getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "FileSizeInLines{" +
                "fileSize=" + fileSize +
                '}';
    }
}
