import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMetaDataTest {
    public static void main(String[] args) throws IOException {
        File inputFile = File.createTempFile("testInputFile", ".txt");

        FileWriter writer = new FileWriter(inputFile);
        writer.write("Test data");
        writer.close();

        System.out.println("File's name: " + FileMetaData.getFileName(inputFile));
        System.out.println("Size of file: " + FileMetaData.getFileSize(inputFile));
        System.out.println("File's last modify date: " +FileMetaData.getFileLastModifyDate(inputFile));
    }
}
