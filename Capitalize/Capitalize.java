import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length == 2) {
            Path source = Paths.get(args[0]);
            Path distination = Paths.get(args[0]);
            String content = Files.readString(source);
            String[] sl = content.split("\\s+");
            List<String> newSl = new ArrayList<>();
            for (String ele : sl) {
                if (ele.length() > 0) {
                    newSl.add(ele.substring(0, 1).toUpperCase() + ele.substring(1, ele.length()));
                }
            }
            Files.writeString(distination, String.join(" ", newSl));
        }
    }

    public static void main(String[] args) throws IOException {
        Capitalize.capitalize(new String[] { "input", "output" });
        String expectedResult = new String(Files.readAllBytes(Paths.get("result")));
        String userOutput = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(expectedResult.equals(userOutput));
    }
}