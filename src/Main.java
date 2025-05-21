import java.io.FileNotFoundException;
import static utils.FileToMatrix.fileToMatrix;
import static utils.MenuAdmin.menuAdmin;

// run program
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        menuAdmin(fileToMatrix("src/resources/IMDV.csv"));
    }
}