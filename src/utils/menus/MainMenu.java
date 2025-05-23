package utils.menus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.matrixHandler.FileToMatrix.fileToMatrix;
import static utils.menus.MenuAdmin.menuAdmin;
import static utils.menus.MenuClient.menuClient;

public class MainMenu {
    public static void mainMenu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String userNameCredential = "";
        String user;

        do {
            System.out.println("******************************");
            System.out.println("       IMDV Login Page        ");
            System.out.println("******************************");
            System.out.println();
            System.out.println("Type of User (ADMIN|CLIENT)");
            System.out.println("[type END to exit]");
            System.out.print("");
            System.out.print("Option: ");
            user = input.next().trim().toUpperCase();
        } while (!user.equals("ADMIN") && !user.equals("CLIENT") && !user.equals("END"));

        if (user.equals("ADMIN")) {
            boolean authenticated;
            do {
                System.out.print("USERNAME: ");
                String username = input.next().trim().toLowerCase();

                System.out.print("PASSWORD: ");
                String password = input.next().trim();

                authenticated = false;

                Scanner fileScanner = new Scanner(new File("src/resources/IMDV_AdminLogin.csv"));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(";");
                    if (parts.length >= 2) {
                        String fileUsername = parts[0].trim().toLowerCase();
                        String filePassword = parts[1].trim();
                        if (fileUsername.equals(username) && filePassword.equals(password)) {
                            authenticated = true;
                            userNameCredential = fileUsername;
                            break;
                        }
                    }
                }

                fileScanner.close();

                if (!authenticated) {
                    System.out.println("Invalid credentials. Try again.");
                }

            } while (!authenticated);

            System.out.println();
            System.out.println("******************************");
            System.out.println("LOGIN SUCCESSFUL! WELCOME, " + userNameCredential.toUpperCase());
            menuAdmin(fileToMatrix("src/resources/IMDV.csv"));
        } else if (user.equals("CLIENT")) {
            System.out.println();
            System.out.println("******************************");
            System.out.println("       LOGIN SUCCESSFUL!      ");
            menuClient(fileToMatrix("src/resources/IMDV.csv"));
        } else {
            System.out.println("ENDING PROGRAM");
        }
    }
}
