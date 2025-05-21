package utils;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static utils.AdminFunctions.*;

//  1. Consulta de Ficheiros: Imprima o conteúdo do ficheiro na consola (deve permitir ver o conteúdo do ficheiro de Ratings).
//  2. Total de Ratings: Imprima quantos ratings foram atribuídos, no total.
//  3. Imprimir Todos os Estúdios: Imprime todos os estúdios já avaliados (sem duplicados).

// menu with options for the admin user
public class MenuAdmin {
    public static void menuAdmin(String[][] matrix) {
        Scanner input = new Scanner(System.in);
        int option;

        // keep showing options while there isn't a valid one,
        // when is valid, show the result of the chosen option
        do {
            System.out.println("1. Check Rating");
            System.out.println("2. Check Number of Rating Until Now");
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
                case 0:
                    System.out.print("Ending Program");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (option != 0);
    }
}
