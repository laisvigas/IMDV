package utils.matrixHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.matrixHandler.CountFileLines.countFileLines;
import static utils.matrixHandler.CountFileColumns.countFileColumns;

public class FileToMatrix {
    /**
     * Function that loads the content of a file into a matrix
     * @return String[][] matrix with the file content
     * @throws FileNotFoundException if file isn't found
     */
    public static String[][] fileToMatrix(String filePath) throws FileNotFoundException {

        // get how many lines the file has | minus 1 because of the header
        int numberOfLines = countFileLines(filePath) - 1;
        int numberOfColumns = countFileColumns(filePath);

        // creates matrix with right length
        String[][] wholeMatrix = new String[numberOfLines][numberOfColumns];

        // creates reading tools
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        // advances header
        sc.nextLine();

        // controls the number of lines
        int positionCurrentLine = 0;

        // while there's line...
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitedLine = line.split(";");

            for (int i = 0; i < wholeMatrix[0].length; i++) {
                wholeMatrix[positionCurrentLine][i] = splitedLine[i];
            }

            positionCurrentLine++;
        }

        sc.close();
        return wholeMatrix;
    }
}
