import java.io.File;
import java.io.IOException;

public class UnarchiveDirTest {
    public static void main(String[] args) {
        File inputDirectory = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\howhow_archive");

        try {
            File outputDirectory = Main.unarchiveDirectory(inputDirectory);
            System.out.println("Директория с разархивированными файлами: " + outputDirectory.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
