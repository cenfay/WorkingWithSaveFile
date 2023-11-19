import java.io.File;
import java.util.List;

public class DeleteFiles {
    public static void deleteFile(List<String> filePaths) {
        for (String filePath : filePaths) {
            File file = new File(filePath);
            if (!file.getName().equals("zip.zip")) {
                file.delete();
            }
        }
    }
}
