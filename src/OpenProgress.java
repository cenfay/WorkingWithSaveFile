import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProgress {
    public static GameProgress openProgress(String filePath) {
        try {
            FileInputStream transformationFileProgress = new FileInputStream(filePath);
            ObjectInputStream fileProgress = new ObjectInputStream(transformationFileProgress);
            GameProgress gameProgress = (GameProgress) fileProgress.readObject();
            fileProgress.close();
            transformationFileProgress.close();
            return gameProgress;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
