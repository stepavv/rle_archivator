import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
    public static File archive(File inputFile) throws IOException {
        File archiveFile = new File(inputFile.getName());
        FileInputStream fis = new FileInputStream(inputFile);
        byte[] compressed = Compression.compress(fis.readAllBytes());
        fis.close();

        FileOutputStream fos = new FileOutputStream(archiveFile);
        fos.write(compressed);
        fos.close();

        return archiveFile;
    }

    public static File[] archive(File[] inputFiles) throws IOException {
        File[] archiveFiles = new File[inputFiles.length];

        for (int i = 0; i < inputFiles.length; i++) {
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            byte[] compressed = Compression.compress(fis.readAllBytes());
            fis.close();

            File archiveFile = new File(inputFiles[i].getName() + ".archive");
            FileOutputStream fos = new FileOutputStream(archiveFile);
            fos.write(compressed);
            fos.close();

            archiveFiles[i] = archiveFile;
        }

        return archiveFiles;
    }




    public static File archiveDirectory(File directory) throws IOException {
        File archiveDir = new File(directory.getAbsolutePath() + "_archive");
        if (!archiveDir.exists()) {
            archiveDir.mkdir();
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Рекурсивный вызов для поддиректорий
                    archiveDirectory(file);
                } else {
                    // Архивирование файла
                    File archivedFile = archive(file);
                    // Помещение архивированного файла в архивную директорию
                    Files.copy(archivedFile.toPath(), new File(archiveDir, file.getName() + ".zip").toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }

        return archiveDir;
    }

    public static File unarchiveDirectory(File inputDirectory) throws IOException {
        File outputDirectory = new File(inputDirectory.getName() + "_unarchived");
        if (!outputDirectory.exists()) {
            outputDirectory.mkdir();
        }

        File[] fileList = inputDirectory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    unarchiveDirectory(file);
                } else {
                    if (file.getName().endsWith(".zip")) {
                        File outputFile = unarchive(file);
                        File newFile = new File(outputDirectory, file.getName().replace(".zip", ""));
                        outputFile.renameTo(newFile);
                    }
                }
            }
        }

        return outputDirectory;
    }


    public static File unarchive(File inputFile) throws IOException {
        File outputFile = new File(inputFile.getName());
        FileInputStream fis = new FileInputStream(inputFile);
        byte[] decompressed = Compression.decompress(fis.readAllBytes());
        fis.close();

        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(decompressed);
        fos.close();

        return outputFile;
    }

    public static File[] unarchive(File[] inputFiles) throws IOException {
        File[] outputFiles = new File[inputFiles.length];

        for (int i = 0; i < inputFiles.length; i++) {
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            byte[] decompressed = Compression.decompress(fis.readAllBytes());
            fis.close();

            File outputFile = new File(inputFiles[i].getName().replace(".archive", ""));
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(decompressed);
            fos.close();

            outputFiles[i] = outputFile;
        }

        return outputFiles;
    }
}
