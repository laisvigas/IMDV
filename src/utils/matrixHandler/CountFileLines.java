package utils.matrixHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFileLines {
    /**
     * Counts the number of non-empty lines in a specified .csv file.
     * A line is considered non-empty if its length is greater than zero after reading.
     * @param pathToFile the path to the file whose lines are to be counted
     * @return the number of non-empty lines in the file
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static int countFileLines(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        Scanner sc = new Scanner(file);
        int lineCounter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() != 0) {
                lineCounter++;
            }
        }
        sc.close();
        return lineCounter;
    }
}
