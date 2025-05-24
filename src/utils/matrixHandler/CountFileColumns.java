package utils.matrixHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFileColumns {
    /**
     * Counts the number of non-empty columns in a specified csv file.
     * A column is considered non-empty if its length is greater than zero after reading.
     * @param pathToFile the path to the file whose columns are to be counted
     * @return the number of non-empty column in the file
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static int countFileColumns(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        Scanner sc = new Scanner(file);

        if (sc.hasNextLine()) {
            String firstLine = sc.nextLine();
            String[] columns = firstLine.split(";");
            sc.close();
            return columns.length;
        }

        sc.close();
        return 0;
    }
}
