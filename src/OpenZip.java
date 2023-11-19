import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class OpenZip {
    public static void openZip(String zipFilePath, String destFolderPath) {
        try {
            FileInputStream extractedFile = new FileInputStream(zipFilePath);
            ZipInputStream archiveFile = new ZipInputStream(extractedFile);
            ZipEntry entry;
            byte[] buffer = new byte[1024];

            while ((entry = archiveFile.getNextEntry()) != null) {
                String fileName = entry.getName();
                File newFileNoArchive = new File(destFolderPath + "/" + fileName);
                FileOutputStream fileNoArchiveSave = new FileOutputStream(newFileNoArchive);

                int len;
                while ((len = archiveFile.read(buffer)) > 0) {
                    fileNoArchiveSave.write(buffer, 0, len);
                }

                fileNoArchiveSave.close();
                archiveFile.closeEntry();
            }

            archiveFile.close();
            extractedFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
