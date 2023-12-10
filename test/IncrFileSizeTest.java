import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IncrFileSizeTest {
    public static void main(String[] args) throws IOException {
        File inputFile = File.createTempFile("testInputFile", ".txt");

        FileWriter writer = new FileWriter(inputFile);
        writer.write("Test data");
        writer.close();

        System.out.println("Size of file: " + FileMetaData.getFileSize(inputFile));
        IncreaseFileSize.padArchiveFile(inputFile, FileMetaData.getFileSize(inputFile) + 10);
        System.out.println("Size of file after expanding: " + FileMetaData.getFileSize(inputFile));
    }
}
