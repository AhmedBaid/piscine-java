import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        Path filepath = Paths.get(fileName);
        Path uu = Files.createFile(filepath);
        Files.writeString(uu, content);
    }

    public static String getContentFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readString(path);
    }

    public static void deleteFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.delete(path);
    }

    public static void main(String[] args) throws IOException {
        FileManager.createFile("file.txt", "Lorem ipsum");
        System.out.println(FileManager.getContentFile("file.txt"));
        FileManager.deleteFile("file.txt");
    }
}