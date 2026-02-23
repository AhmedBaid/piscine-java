import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        for (String file : args) {
            Path filepath = Paths.get(file);
            Files.copy(System.in, filepath);
        }
    }
}