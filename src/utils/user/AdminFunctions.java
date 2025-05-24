package utils.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// functions related to admin user
public class AdminFunctions {
    /**
     * Prints all information contained in the IMDV matrix.
     * This function iterates through each cell of the matrix and prints all its contents.
     * Each line of the matrix is printed on a new line.
     * @param matrix representing the IMDV database
     */
    public static void allIMDVinfo(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // replace ; for |
            String formattedLine = line.replace(";", " | ");
            System.out.println(formattedLine);
        }

        sc.close();
    }

    /**
     * Calculates the total number of ratings in the IMDV matrix
     * assuming each row represents a unique rating entry.
     * @param matrix representing the IMDV database
     * @return the total number of rows, interpreted as the total number of ratings
     */
    public static int totalRatings(String[][] matrix) {
        int countRatings = 0;
        for (int line = 0; line < matrix.length; line++) {
            countRatings++;
        }
        return countRatings;
    }

    /**
     * Prints all unique studio names from the IMDV matrix.
     * The function iterates through the 5th index of the matrix and prints each studio name once
     * A temporary array is used to track and compare previously found studios.
     * @param matrix representing the IMDV database
     */
    public static void printAllStudiosWithoutDuplicate(String[][] matrix) {
        String[] studios = new String[matrix.length];
        int uniqueCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            String studioMatrix = matrix[i][5];
            boolean alreadyExists = false;

            // check if studioMatrix is already in the studios array
            for (int j = 0; j < uniqueCount; j++) {
                if (studios[j].equals(studioMatrix)) {
                    alreadyExists = true;
                    break;
                }
            }

            // if it's not in the array yet, add it to the array and print it
            if (!alreadyExists) {
                studios[uniqueCount] = studioMatrix;
                uniqueCount++;
                System.out.println(studioMatrix);
            }
        }
    }
}
