import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchiveDirTest {
    public static void main(String[] args) throws IOException {
        File testDir = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\howhow");
        File file1 = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\howhow\\test.txt");
        File file2 = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\howhow\\test2.txt");

        try (FileWriter writer1 = new FileWriter(file1);
             FileWriter writer2 = new FileWriter(file2)) {
            writer1.write("hello");
            writer2.write("world");
            // Убедитесь, что запись завершена перед архивацией
            writer1.flush();
            writer2.flush();
            File archivedDir = Main.archiveDirectory(testDir);
            System.out.println("Директория успешно заархивирована в: " + archivedDir.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при архивировании директории: " + e.getMessage());
        }
    }
}
