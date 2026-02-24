import java.io.File;
import java.io.IOException;

public class FileSearch {
    public static String searchFile(String fileName) {
        File doc = new File("documents");
        return recursive(doc, fileName);
    }

    private static String recursive(File directory, String fileName) {
        File[] list = directory.listFiles();
        if (list == null) {
            return null;
        }

        for (File file : list) {
            if (file.isDirectory()) {
                String result = recursive(file, fileName);
                if (result != null) {
                    return result;
                }
            }
            else if (file.getName().equals(fileName)) {
                return file.getPath();
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FileSearch.searchFile("file.txt"));
    }
}