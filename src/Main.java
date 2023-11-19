import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String saveFile1 = "C:/Games/savegames/save1.dat";
        String saveFile2 = "C:/Games/savegames/save2.dat";
        String saveFile3 = "C:/Games/savegames/save3.dat";
        String saveFile4 = "C:/Games/savegames/";

        GameProgress game1 = new GameProgress(1200, 34, 9, 0.3);
        GameProgress game2 = new GameProgress(3900, 48, 19, 0.6);
        GameProgress game3 = new GameProgress(7900, 70, 30, 1.0);

        CreatureFileSaveGame.saveGame(saveFile1, game1);
        CreatureFileSaveGame.saveGame(saveFile2, game2);
        CreatureFileSaveGame.saveGame(saveFile3, game3);

        List<String> saveFile = new ArrayList<>();
        saveFile.add(saveFile1);
        saveFile.add(saveFile2);
        saveFile.add(saveFile3);

        String zipFile = "C:/Games/savegames/zip.zip";
        CreatureZipFiles.zipFiles(zipFile, saveFile);

        DeleteFiles.deleteFile(saveFile);

        OpenZip.openZip(zipFile, saveFile4);

        GameProgress gameProgress1 = OpenProgress.openProgress(saveFile1);
        System.out.println(gameProgress1);
    }
}







