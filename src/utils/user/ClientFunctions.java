package utils.user;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientFunctions {
    public static void registerSimulator() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = input.nextLine();


        System.out.print("Enter Contact: ");
        String contact = input.nextLine();

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.println("User sucessfully registered: " + name + " | " + contact + " | " + email);
    }

    public static String printCatalogMoviesAndRatings(String[][] matrix) {
        String[] movies = new String[matrix.length];
        String[] ratings = new String[matrix.length];
        int uniqueCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            String movieMatrix = matrix[i][1];
            String ratingMatrix = matrix[i][2];
            boolean alreadyExists = false;

            // check if the information are already in the array
            for (int j = 0; j < uniqueCount; j++) {
                if (movies[j].equals(movieMatrix)) {
                    alreadyExists = true;
                    break;
                }
            }

            // if it's not in the array yet, add it to the array and print it
            if (!alreadyExists) {
                movies[uniqueCount] = movieMatrix;
                ratings[uniqueCount] = ratingMatrix;
                uniqueCount++;
                System.out.println(movieMatrix + " | " + ratingMatrix);
            }
        }
        return "";
    }

    public static String printGraphicCatalog(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
        return "";
    }

    public static String bestStudio(String[][] matrix) {
        /**
         * Function returns the best studio
         * @param matrix with all movies
         */

        float highestRating = Float.parseFloat(matrix[0][2]);
        String bestStudio = "";

        for (int line = 0; line < matrix.length; line++) {
                if (Float.parseFloat(matrix[line][2]) > highestRating){
                    highestRating = Float.parseFloat(matrix[line][2]);
                    bestStudio = matrix[line][5];
                }

        }
         return bestStudio;
    }

    public static String worstStudio(String[][] matrix) {
        /**
         * Function returns the worst studio
         * @param matrix with all movies
         */

        float lowestRating = Float.parseFloat(matrix[0][2]);
        String worstStudio = "";

        for (int line = 0; line < matrix.length; line++) {
            if (Float.parseFloat(matrix[line][2]) < lowestRating){
                lowestRating = Float.parseFloat(matrix[line][2]);
                worstStudio = matrix[line][5];
            }

        }
        return worstStudio;
    }

    public static String lastCritic(String[][] matrix) {
        String[] lastLine = matrix[matrix.length - 1];
        return (String.join(" | c", lastLine));
    }

}
