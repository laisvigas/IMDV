package utils.user;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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

    public static void printCatalogMoviesAndRatings(String[][] matrix) {
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

    public static void searchByStudio(String[][] matrix) {
        /**
         * Function that searches movies by studio and prints the title and genre
         * @param matrix with all movies
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Studio Name: ");
        String studioToBeSearched = input.nextLine().trim().toLowerCase();

        boolean found = false;

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Results for studio: " + studioToBeSearched.toUpperCase());
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-50s | %-15s\n", "Movies", "Genre");
        System.out.println("---------------------------------------------------------------");

        for (int line = 0; line < matrix.length; line++) {
            if (matrix[line][5].equalsIgnoreCase(studioToBeSearched)) {
                System.out.printf("%-50s | %-15s\n", matrix[line][1], matrix[line][7]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found for this studio.");
        }

        System.out.println("---------------------------------------------------------------\n");
    }

    public static void searchByGenre(String[][] matrix) {
        /**
         * Function that searches movies by studio and prints the title and genre
         * @param matrix with all movies
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Genre: ");
        String genreToBeSearched = input.nextLine().trim().toLowerCase();

        boolean found = false;

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Results for genre: " + genreToBeSearched.toUpperCase());
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-30s | %-15s\n", "Studios", "Movies");
        System.out.println("---------------------------------------------------------------");

        for (int line = 0; line < matrix.length; line++) {
            if (matrix[line][7].equalsIgnoreCase(genreToBeSearched)) {
                System.out.printf("%-30s | %-15s\n", matrix[line][5], matrix[line][1]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found for this genre.");
        }

        System.out.println("---------------------------------------------------------------\n");
    }

    public static void quiz (String[][] matrix) {
        Scanner input = new Scanner(System.in);
        int currentMatrixAnswer = 0;
        int userAnswer;
        int points = 0;

        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (col == 0) {
                    System.out.println(matrix[line][col]);
                } else if (col < matrix.length) {
                    System.out.println(col + "." + matrix[line][col]);
                }
                currentMatrixAnswer = Integer.parseInt(matrix[line][matrix.length]);
            }

            System.out.print("Answer: ");
            
            userAnswer = input.nextInt();

            if (currentMatrixAnswer == userAnswer) {
                System.out.println("Right Answer!");
                System.out.println();
                points++;
            } else{
                System.out.println("Wrong Answer!");
                System.out.println();
            }
        }
        System.out.println("End of Quiz");
        System.out.println("Total Points: " + points);
        System.out.println();
    }
}
