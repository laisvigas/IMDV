package utils.menus;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.menus.MainMenu.mainMenu;
import static utils.user.AdminFunctions.*;
import static utils.user.ClientFunctions.printGraphicCatalog;

// menu with options for the admin user
public class MenuAdmin {
    /**
     * Displays the admin menu, processes user input, and calls the appropriate
     * admin functions based on the selected option.
     * The menu continues to display until the user chooses to exit the program.
     * @param matrix loaded from a .csv file
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static String menuAdmin(String[][] matrix) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("******************************");
        System.out.println("       IMDV Admin Page        ");
        System.out.println("******************************");
        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option
        do {
            System.out.println("             MENU             ");
            System.out.println("******************************");
            System.out.println("1. Check IMDV DB");
            System.out.println("2. Check number of rating until now");
            System.out.println("3. Check Studios");
            System.out.println("4. Back to Main Menu");
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
                    System.out.println("IMDV DB:");
                    allIMDVinfo("src/resources/IMDV.csv");
                    System.out.println("******************************");
                    break;
                case 2:
                    System.out.print("NUMBER OF RATINGS UNTIL NOW: " + totalRatings(matrix) + "\n");
                    System.out.println();
                    System.out.println("******************************");
                    break;
                case 3:
                    System.out.println("ALL STUDIOS:");
                    printAllStudiosWithoutDuplicate(matrix);
                    System.out.println();
                    System.out.println("******************************");
                    break;
                case 4:
                    return "BACK";
                case 0:
                    return "EXIT";
                default:
                    System.out.println("Invalid Option");
                    System.out.println();
                    System.out.println("******************************");
                    break;
            }
        } while (true);
    }
}
