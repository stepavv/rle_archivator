import java.io.File;
import java.io.IOException;

public class FileArrayTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\test1.txt");
        File file2 = new File("C:\\Users\\user\\dev\\JavaDev\\RleArchiver\\test2.txt");

        File[] arr = new File[]{file1, file2};
        File[] w = Main.archive(arr);
        for (File f : w) {
            ArchiveUnarchiveTest.fileContentReader(f);
        }

        File[] l = Main.unarchive(w);
        for (File f : l) {
            ArchiveUnarchiveTest.fileContentReader(f);
        }
    }
}
