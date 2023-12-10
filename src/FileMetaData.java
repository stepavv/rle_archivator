import java.io.File;
import java.util.Date;

public class FileMetaData {

    public static String getFileName(File file) {
        return file.getName().replaceAll("[0-9]","");
    }

    public static long getFileSize(File file) {
        // System.out.println("Size of file" + FileMetaData.getFileName(file) + " is: "  + file.length());
        return file.length();
    }

    public static Date getFileLastModifyDate(File file) {
        return new Date(file.lastModified());
    }
}
