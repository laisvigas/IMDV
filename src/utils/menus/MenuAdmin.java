package utils.menus;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.user.AdminFunctions.*;
import static utils.user.ClientFunctions.printGraphicCatalog;

// menu with options for the admin user
public class MenuAdmin {
    public static void menuAdmin(String[][] matrix) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int option;

        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option
        do {
            System.out.println("1. Check Rating");
            System.out.println("2. Check Number of Rating Until Now");
            System.out.println("3. Check Studios");
            System.out.println("0. End Program");
            System.out.print("Option: ");
            option = input.nextInt();

            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("Checking column ratings: ");
                    columnRatings(matrix);
                    break;
                case 2:
                    System.out.print("Number of Ratings Until Now: ");
                    System.out.println(totalRatings(matrix));
                    break;
                case 3:
                    System.out.println("See all Studios: ");
                    System.out.print(printAllStudiosWithoutDuplicate(matrix));
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
