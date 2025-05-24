package utils.menus;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.matrixHandler.FileToMatrix.fileToMatrix;
import static utils.menus.MainMenu.mainMenu;
import static utils.user.ClientFunctions.*;

// menu with options for the client user
public class MenuClient {
    /**
     * Displays the client menu, processes user input, and calls the appropriate
     * client functions based on the selected option.
     * The menu keeps running until the user chooses to end the program.
     * @param matrix loaded from a .csv file
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static void menuClient(String[][] matrix) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("******************************");
        System.out.println("       IMDV Client Page        ");
        System.out.println("******************************");

        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option or exit if it's 0
        do {
            System.out.println("             MENU             ");
            System.out.println("******************************");
            System.out.println("1. Register User");
            System.out.println("2. Show Movie Catalog");
            System.out.println("3. Show Graphic Catalog");
            System.out.println("4. Show Best Studio");
            System.out.println("5. Show Worst Studio");
            System.out.println("6. Last Critic");
            System.out.println("7. Quiz");
            System.out.println("8. Search Movies by Studio");
            System.out.println("9. Search Movies by Genre");
            System.out.println("10. Back To Main Menu");
            System.out.println("0. End Program");
            System.out.print("Option: ");
            String userInput = input.nextLine();

            try {
                // convert user input to int
                option = Integer.parseInt(userInput);
            } catch (NumberFormatException exception) {
                System.out.println("******************************\n");
                System.out.println("Invalid input! Please enter a valid number.\n");
                System.out.println("******************************");
                // back to the beginning of the loop
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("REGISTER USER:");
                    registerSimulator();
                    System.out.println("******************************");
                    break;
                case 2:
                    System.out.println("MOVIE CATALOG | MOVIES AND RATINGS:");
                    printCatalogMoviesAndRatings(matrix);
                    System.out.println("******************************");
                    break;
                case 3:
                    // user will be able to choose an image from this sub-menu
                    System.out.println("GRAPHIC CATALOG");
                    System.out.println();
                    System.out.println("Choose which movie poster you want to see: ");
                    System.out.println("1. Harry Potter");
                    System.out.println("2. Interstellar");
                    System.out.println("3. Lord of the Rings");
                    System.out.println("4. Star Wars");
                    System.out.print("Enter Choice: ");
                    int chosenCatalog = input.nextInt();
                    input.nextLine();

                    // prints image based on the user choice
                    switch (chosenCatalog) {
                        case 1:
                            printGraphicCatalog("src/resources/CatalogoGrafico/HarryPotter.txt");
                            break;
                        case 2:
                            printGraphicCatalog("src/resources/CatalogoGrafico/Interstellar.txt");
                            break;
                        case 3:
                            printGraphicCatalog("src/resources/CatalogoGrafico/LordOfTheRings.txt");
                            break;
                        case 4:
                            printGraphicCatalog("src/resources/CatalogoGrafico/StarWars.txt");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            System.out.println("******************************");
                    }
                    break;
                case 4:
                    System.out.print("BEST STUDIO: ");
                    studioRatingsBestWorst(matrix, "best");
                    System.out.println();
                    System.out.println("******************************");
                    break;
                case 5:
                    System.out.print("WORST STUDIO: ");
                    studioRatingsBestWorst(matrix, "worst");
                    System.out.println();
                    System.out.println("******************************");
                    break;
                case 6:
                    System.out.println();
                    System.out.println("LAST CRITIC: ");
                    System.out.println(lastCritic(matrix));
                    System.out.println();
                    System.out.println("******************************\n");
                    break;
                case 7:
                    System.out.println("MOVIE QUIZ!");
                    System.out.println();
                    quiz(fileToMatrix("src/resources/IMDV_Quiz.csv"));
                    System.out.println("******************************\n");
                    break;
                case 8:
                    System.out.println("MOVIES BY STUDIO: ");
                    searchByStudio(matrix);
                    System.out.println("******************************");
                    break;
                case 9:
                    System.out.println("MOVIES BY GENRE: ");
                    searchByGenre(matrix);
                    System.out.println("******************************");
                    break;
                case 10:
                    mainMenu();
                    break;
                case 0:
                    System.out.println("ENDING PROGRAM");
                    printGraphicCatalog("src/resources/IMDV_Copyright.txt");
                    System.out.println();
                    System.out.println("************************************************************");
                    // end program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
                    System.out.println("******************************");
                    break;
            }
        } while (true);
    }
}
