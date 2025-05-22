package utils.menus;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static utils.user.AdminFunctions.totalRatings;
import static utils.user.ClientFunctions.printCatalogMoviesAndRatings;
import static utils.user.ClientFunctions.*;

public class MenuClient {
    public static void menuClient(String[][] matrix) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int option;

        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option
        do {
            System.out.println("1. Register User");
            System.out.println("2. Show Movie Catalog");
            System.out.println("3. Show Graphic Catalog");
            System.out.println("4. Show Best Studio");
            System.out.println("5. Show Worst Studio");
            System.out.println("6. Last Critic");
            System.out.println("7. Quiz");
            System.out.println("0. End Program");
            System.out.print("Option: ");
            option = input.nextInt();

            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("REGISTER USER");
                    registerSimulator();
                    break;
                case 2:
                    System.out.println("MOVIE CATALOG");
                    printCatalogMoviesAndRatings(matrix);
                    break;
                case 3:
                    System.out.println("GRAPHIC CATALOG: ");
                    System.out.println("MOVIE CATALOG: ");
                    System.out.println();
                    System.out.println("Choose which movie poster you want to see: ");
                    System.out.println("1. Harry Potter");
                    System.out.println("2. Interstellar");
                    System.out.println("3. Lord of the Rings");
                    System.out.println("4. Star Wars");
                    System.out.print("Enter Choice: ");
                    int chosenCatalog = input.nextInt();

                    switch (chosenCatalog) {
                        case 1:
                            System.out.println(printGraphicCatalog("src/resources/CatalogoGrafico/HarryPotter.txt"));
                            break;
                        case 2:
                            System.out.println(printGraphicCatalog("src/resources/CatalogoGrafico/Interstellar.txt"));
                            break;
                        case 3:
                            System.out.println(printGraphicCatalog("src/resources/CatalogoGrafico/LordOfTheRings.txt"));
                            break;
                        case 4:
                            System.out.println(printGraphicCatalog("src/resources/CatalogoGrafico/StarWars.txt"));
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                case 4:
                    System.out.println("BEST STUDIO");
                    System.out.println(bestStudio(matrix));
                    System.out.println();
                    break;
                case 5:
                    System.out.println("WORST STUDIO");
                    System.out.println(worstStudio(matrix));
                    System.out.println();
                    break;
                case 6:
                    System.out.println("LAST CRITIC");
                    System.out.println(lastCritic(matrix));
                    System.out.println();
                    break;
                case 7:
                    System.out.print("QUIZ");
                    break;
                case 8:
                    System.out.print("todo");
                    break;
                case 9:
                    System.out.print("todo");
                    break;
                case 0:
                    System.out.println("Ending Program");
                    System.out.println(printGraphicCatalog("src/resources/IMDV_Copyright.txt"));
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (option != 0);
    }
}
