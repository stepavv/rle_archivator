import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IncreaseFileSize {
    public static void padArchiveFile(File archiveFile, long desiredSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(archiveFile, "rw");
        long currentSize = raf.length();

        if (currentSize < desiredSize) {
            long bytesToAdd = desiredSize - currentSize;
            raf.seek(currentSize);
            for (int i = 0; i < bytesToAdd; i++) {
                raf.writeByte(0);
            }
        }
        raf.close();
    }
}
