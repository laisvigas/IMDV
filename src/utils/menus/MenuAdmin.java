package utils.menus;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static utils.matrixHandler.FileToMatrix.fileToMatrix;
import static utils.menus.MainMenu.mainMenu;
import static utils.menus.MenuClient.menuClient;
import static utils.user.AdminFunctions.*;
import static utils.user.ClientFunctions.printGraphicCatalog;

// menu with options for the admin user
public class MenuAdmin {
    public static void menuAdmin(String[][] matrix) throws FileNotFoundException {
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
            option = input.nextInt();
            System.out.println();
            System.out.println("******************************\n");

            switch (option) {
                case 1:
                    System.out.println("IMDV DB:");
                    allIMDVinfo(matrix);
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
                    mainMenu();
                    break;
                case 0:
                    System.out.println("ENDING PROGRAM");
                    System.out.println(printGraphicCatalog("src/resources/IMDV_Copyright.txt"));
                    System.out.println();
                    System.out.println("************************************************************");
                    break;
                default:
                    System.out.println("Invalid Option");
                    System.out.println();
                    System.out.println("******************************");
                    break;
            }
        } while (option != 0);
    }
}
