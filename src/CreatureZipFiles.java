import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreatureZipFiles {
    public static void zipFiles(String zipPath, List<String> filePaths) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(zipPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
            for (String filePath : filePaths) {
                File file = new File(filePath);
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) >= 0) {
                    zipOutputStream.write(buffer, 0, length);
                }

                fileInputStream.close();
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
