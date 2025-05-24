package utils.menus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.matrixHandler.FileToMatrix.fileToMatrix;
import static utils.menus.MenuAdmin.*;
import static utils.menus.MenuClient.menuClient;
import static utils.user.ClientFunctions.printGraphicCatalog;

public class MainMenu {

    /**
     * Prints a message indicating that the program is ending,
     * displays a graphic catalog by reading a file containing copyright
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static void endingProgram() throws FileNotFoundException {
        System.out.println("ENDING PROGRAM");
        printGraphicCatalog("src/resources/IMDV_Copyright.txt");
        System.out.println("\n************************************************************");
    }

    /**
     * Displays the login menu for the IMDV system and redirects users to their corresponding
     * interfaces based on their role (ADMIN or CLIENT).
     * ADMIN users must provide a valid username and password found in a .csv file.
     * CLIENT users are granted direct access to the client interface.
     * @throws FileNotFoundException if the credentials file or the matrix file cannot be found
     */
    public static void mainMenu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String userNameCredential = "";
        String user;

        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option
        while (true) {
            do {
                System.out.println("******************************");
                System.out.println("       IMDV Login Page        ");
                System.out.println("******************************");
                System.out.println();
                System.out.println("Type of User (ADMIN|CLIENT)");
                System.out.println("[type END to exit]");
                System.out.print("");
                System.out.print("Option: ");
                user = input.nextLine().trim().toUpperCase();

                // check if input is invalid (not ADMIN, CLIENT, or END)
                if (!user.equals("ADMIN") && !user.equals("CLIENT") && !user.equals("END")) {
                    System.out.println("\n>>> Invalid option!\n>>> Please enter ADMIN, CLIENT, or END.\n");
                }

            } while (!user.equals("ADMIN") && !user.equals("CLIENT") && !user.equals("END"));

            if (user.equals("END")) {
                endingProgram();
                return;
            }

            if (user.equals("ADMIN")) {
                boolean authenticated;
                do {
                    System.out.print("USERNAME: ");
                    String username = input.nextLine().trim().toLowerCase();

                    System.out.print("PASSWORD: ");
                    String password = input.nextLine();

                    authenticated = false;

                    Scanner fileScanner = new Scanner(new File("src/resources/IMDV_AdminLogin.csv"));
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(";");
                        if (parts.length >= 2) {
                            String fileUsername = parts[0].trim().toLowerCase();
                            String filePassword = parts[1];
                            if (fileUsername.equals(username) && filePassword.equals(password)) {
                                // authenticates only after check if password and username matches the .csv
                                authenticated = true;
                                userNameCredential = fileUsername;
                                break;
                            }
                        }
                    }

                    fileScanner.close();

                    if (!authenticated) {
                        // asks for credentials again if not authenticated
                        System.out.println();
                        System.out.println("""
                                >>> Invalid credentials.\
                                
                                >>> Check if upper and lower cases\
                                
                                >>> are right for the password\
                                
                                >>> and if the username is spelled right.
                                """);

                        System.out.println("TRY AGAIN");
                    }

                } while (!authenticated);

                System.out.println();
                System.out.println("******************************");
                System.out.println("LOGIN SUCCESSFUL! WELCOME, " + userNameCredential.toUpperCase());

                // when authenticated as ADMIN, loads the admin menu
                while (true) {
                    String status = menuAdmin(fileToMatrix("src/resources/IMDV.csv"));
                    if (status.equals("BACK")) {
                        // breaks the loop on adminMenu and go back to MainManu
                        break;
                    } else if (status.equals("EXIT")) {
                        endingProgram();
                        return;
                    }
                }
            }
            if (user.equals("CLIENT")) {
                System.out.println("\n******************************");
                System.out.println("       LOGIN SUCCESSFUL!      ");
                while (true) {
                    String status = menuClient(fileToMatrix("src/resources/IMDV.csv"));
                    if (status.equals("BACK")) {
                        // breaks the loop on clientMenu and go back to MainManu
                        break;
                    } else if (status.equals("EXIT")) {
                        endingProgram();
                        return;
                    }
                }
            }
        }
    }
}
