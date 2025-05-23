package utils.user;

// functions related to admin user
public class AdminFunctions {
    /**
     * Prints the values in the Ratings column (third column) from the given matrix
     */
    public static void allIMDVinfo(String[][] matrix) {
        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[line][col]);
            }
            System.out.println(" ");
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

    /**
     * Prints all unique studio names found in the given matrix
     * @return An empty string ""
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
