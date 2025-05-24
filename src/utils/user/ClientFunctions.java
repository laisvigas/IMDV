package utils.user;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientFunctions {
    /**
     * Checks if the name passed as an argument is invalid.
     * The name is invalid if null, empty, or if it contains numbers
     * @param name the input name to validate
     * @return true if the name is invalid; false if it's not
     */
    public static boolean isInvalidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            // return true for invalid cases
            return true;
        }
        // returns true if contains number
        return name.matches(".*\\d.*");
    }

    /**
     * Checks if the contact passed as an argument is invalid.
     * The contact is invalid if null, empty, or if it contains letters
     * @param contact the input name to validate
     * @return true if the contact is invalid; false if it's not
     */
    public static boolean isInvalidContact(String contact) {
        if (contact == null || contact.trim().isEmpty()) {
            // return true for invalid cases
            return true;
        }
        // returns true if contains letters
        return !contact.matches("^[0-9]+$");
    }

    /**
     * Checks if the email passed as an argument is invalid.
     * The email is invalid if null, empty, or if it's not following the regex
     * @param email the input name to validate
     * @return true if the email is invalid; false if it's not
     */
    public static boolean isInvalidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return true;
        }
        // returns true if invalid
        return !email.matches("^(?i)[\\w.-]+@([\\w-]+\\.)+[A-Za-z]{2,6}$");
    }

    /**
     * Simulates user registration by asking user input.
     * Prompts the user to enter their name, contact, and email and validate it though functions.
     * After receiving the input and if the inputs are valid, it prints a confirmation message with the entered data.
     * This function does not perform any validation or store the data.
     */
    public static void registerSimulator() {
        Scanner input = new Scanner(System.in);
        String name, contact, contactNoWhiteSpaces, email;

        // validating name
        do {
            System.out.print("Enter Name: ");
            name = input.nextLine().trim();
            if (isInvalidName(name)) {
                System.out.println(">>>Oooops, invalid name!\n>>>Names should contain only letters.");
            }
        } while (isInvalidName(name));

        // validating contact
        do {
            System.out.print("Enter Contact: ");
            // passed as a string because how it's handled in the validateContact function
            contact = input.nextLine().trim();
            contactNoWhiteSpaces = contact.replaceAll("\\s+", "");
            if (isInvalidContact(contactNoWhiteSpaces)) {
                System.out.println(">>>Oooops, invalid contact!\n>>>Contacts should contain only numbers.");
            }
        } while (isInvalidContact(contactNoWhiteSpaces));

        do {
            System.out.print("Enter Email: ");
            email = input.nextLine().trim().toLowerCase();
            if (isInvalidEmail(email)) {
                System.out.println(">>>Oooops, invalid email!\n>>>Please enter a valid email address.");
            }
        } while (isInvalidEmail(email));

        System.out.println("User successfully registered: " + name + " | " + contactNoWhiteSpaces + " | " + email);
    }

    /**
     * Prints a list of movies along with their ratings from a given matrix.
     * Each row in the matrix is expected to contain movie data, where the movie title
     * is located at index 1 and the corresponding rating at index 2.
     * Duplicate movie titles are ignored.
     @param matrix representing the IMDV database.
     */
    public static void printCatalogMoviesAndRatings(String[][] matrix) {
        String[] movies = new String[matrix.length];
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
                uniqueCount++;
                System.out.println(movieMatrix + " | " + ratingMatrix);
            }
        }
    }

    /**
     * Reads and prints the contents of a .txt file representing a graphic image.
     * This function reads the file line by line and prints each line to the console.
     * @param filePath The path to the text file to be read.
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static void printGraphicCatalog(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }

        sc.close();
    }

    /**
     * Analyzes a matrix of movie database to determine and display the studio with either the highest
     * or lowest average rating, depending on the specified input.
     * The matrix is expected to have movie ratings in column index 2 and studio names in column index 5.
     * It calculates the average rating for each unique studio and prints either the best or worst
     * studio according to the specified input.
     * @param matrix representing the IMDV database.
     * @param input A string to show the desired information "best" to display the studio
     *              with the highest average rating, or "worst" to display the one with the lowest.
     * @throws NumberFormatException If a rating in the matrix cannot be parsed as a double.
     */
    public static void studioRatingsBestWorst(String[][] matrix, String input) {
        // arrays to store unique studio names, total rating sums, and number of ratings
        String[] studios = new String[matrix.length];
        double[] ratingsSum = new double[matrix.length];
        int[] counts = new int[matrix.length];

        // counter for the number of unique studios found
        int uniqueStudiosCount = 0;

        // loop through each row of the matrix | studio is in column index 5 and ratings in column 2
        for (int i = 0; i < matrix.length; i++) {
            String currentStudio = matrix[i][5];
            double currentRating = Double.parseDouble(matrix[i][2]);

            int position = -1;
            for (int j = 0; j < uniqueStudiosCount; j++) {
                if (studios[j].equals(currentStudio)) {
                    position = j;
                    break;
                }
            }

            if (position == -1) {
                // studio not found, add it as a new entry
                studios[uniqueStudiosCount] = currentStudio;
                ratingsSum[uniqueStudiosCount] = currentRating;
                counts[uniqueStudiosCount] = 1;
                // increment the unique studio count
                uniqueStudiosCount++;
            } else {
                // studio found, update the total ratings sum and count
                ratingsSum[position] += currentRating;
                counts[position]++;
            }
        }

        // store studio with the lowest average rating,starting with 0
        double highestAverage = 0;
        String bestStudio = "";

        // store studio with the lowest average rating, assuming it goes from 1 to 10
        double lowestAverage = 10;
        String worstStudio = "";

        for (int i = 0; i < uniqueStudiosCount; i++) {
            // store the average rating
            double average = ratingsSum[i] / counts[i];

            if (average > highestAverage) {
                highestAverage = average;
                bestStudio = studios[i];
            }

            if (average < lowestAverage) {
                lowestAverage = average;
                worstStudio = studios[i];
            }
        }

        // print the result based on input parameter "best" or "worst"
        switch (input.toLowerCase()) {
            case "best":
                System.out.println(bestStudio + " | " + highestAverage);
                break;
            case "worst":
                System.out.println(worstStudio + " | " + lowestAverage);
                break;
            default:
                System.out.println("Invalid parameter. Use 'best' or 'worst'.");
        }
    }

    /**
     * Returns a formatted last row string of the matrix
     * Each field in the row is joined by " | " for better visualization.
     * @param matrix representing the IMDV database.
     * @return A string with the contents of the last row.
     */
    public static String lastCritic(String[][] matrix) {
        String[] lastLine = matrix[matrix.length - 1];
        return (String.join(" | ", lastLine));
    }

    /**
     * Prompts the user to enter a studio name, then searches the matrix for all movies
     * and prints the titles and genres in a formatted table.
     * @param matrix representing the IMDV database.
     */
    public static void searchByStudio(String[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Studio Name: ");
        String studioToBeSearched = input.nextLine().trim().toUpperCase();

        boolean found = false;

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Results for studio: " + studioToBeSearched.toUpperCase());
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-50s | %-15s\n", "Movies", "Genre");
        System.out.println("-----------------------------------------------------------------");

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

    /**
     * Prompts the user to enter a genre, then searches the matrix for all movies
     * and prints the titles and studios in a formatted table.
     * @param matrix representing the IMDV database.
     */
    public static void searchByGenre(String[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Genre: ");
        String genreToBeSearched = input.nextLine().trim().toUpperCase();

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

    /**
     * Runs a quiz game using the provided matrix of questions and answers.
     * The matrix must be formatted so that:
     * - Each row represents a single question.
     * - Column 0 contains the question text.
     * - The following columns contain the possible answer options.
     * - The last column contains the index (int) of the correct answer option.
     * The user is prompted to answer each question by entering the number corresponding to their chosen option.
     * The function counts the correct answers and prints the total score at the end.
     * @param matrix representing the IMDV database.
     */
    public static void quiz (String[][] matrix) {
        Scanner input = new Scanner(System.in);
        int currentMatrixAnswer = 0;
        String userAnswer;
        int userAnswerInt;
        int points = 0;

        for (int line = 0; line < matrix.length; line++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (col == 0) {
                    // prints the question without a number
                    System.out.println(matrix[line][col].toUpperCase());

                    // prints the options with numbers, ex: 1. Tatooine, 2. Endor...
                } else if (col < matrix.length) {
                    System.out.println(col + "." + matrix[line][col]);
                }
                // stores the right answer for the current question
                currentMatrixAnswer = Integer.parseInt(matrix[line][matrix.length]);
            }

            // enter a loop to resolve invalid inputs
            boolean validInput = false;
            do {
                System.out.print("Answer: ");
                userAnswer = input.nextLine();

                try {
                    userAnswerInt = Integer.parseInt(userAnswer);

                    if (userAnswerInt >= 1 && userAnswerInt <= 4) {
                        validInput = true;

                        if (currentMatrixAnswer == userAnswerInt) {
                            System.out.println("Right Answer!\n");
                            points++;
                        } else {
                            System.out.println("Wrong Answer! The correct was number: " + currentMatrixAnswer + "\n");
                        }
                    } else {
                        System.out.println("Please enter a number between 1 and 4 only.\n");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Ooops! You entered a text, please enter a number between 1 and 4.\n");
                }
            } while (!validInput);
        }
        System.out.println("END OF QUIZ | Total Points: " + points + "\n");
    }
}
