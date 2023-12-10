import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

@RunWith(JUnit4.class)

public class ArchiveUnarchiveTest {
    public static void testArchive() throws IOException {
        File inputFile = File.createTempFile("testInputFile", ".txt");

        FileWriter writer = new FileWriter(inputFile);
        writer.write("Test data");
        writer.close();

        File archivedFile = Main.archive(inputFile);

        boolean equal = isEqual(inputFile, Main.unarchive(archivedFile));
        if (equal) {
            System.out.println("Files are equal.");
        } else {
            System.out.println("Files are not equal.");
        }

        fileContentReader(inputFile);
        fileContentReader(archivedFile);
        //fileContentReader(RleArchiver.unarchive(archivedFile));

        /*System.out.println("Имя файла: " + FileMetaData.getFileName(inputFile));
        System.out.println("Размер файла " + FileMetaData.getFileName(inputFile) + " равен " + FileMetaData.getFileSize(inputFile));
        System.out.println("Дата последнего изменения файла "
                + FileMetaData.getFileName(inputFile) + ": "
                + FileMetaData.getFileLastModifyDate(inputFile));*/
    }

    private static boolean isEqual(File firstFile, File secondFile) {
        try {
            return FileUtils.contentEquals(firstFile, secondFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void fileContentReader(File fileToRead) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        testArchive();
    }
}


