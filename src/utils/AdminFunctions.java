package utils;
import java.io.FileNotFoundException;

// functions related to admin user
public class AdminFunctions {
    /**
     * Prints the values in the Ratings column (third column) from the given matrix
     */
    public static void columnRatings(String[][] matrix) {
        for (int line = 0; line < matrix.length; line++) {
            System.out.println(matrix[line][2]);
        }
    }

    /**
     * Counts the values in the Ratings column (third column) from the given matrix
     */
    public static int totalRatings(String[][] matrix) {
        int countRatings = 0;
        for (int line = 0; line < matrix.length; line++) {
            countRatings++;
        }
        return countRatings;
    }
}
