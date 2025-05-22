package utils.matrixHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFileLines {
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
