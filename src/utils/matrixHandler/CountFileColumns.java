package utils.matrixHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFileColumns {
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
