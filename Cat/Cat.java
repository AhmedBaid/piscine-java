import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String file : args) {

            try (FileInputStream fis = new FileInputStream(file)) {

                int chunkSize = 4096;
                byte[] buffer = new byte[chunkSize];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, bytesRead));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PrintStream stdout = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Cat.cat(new String[] { "input.txt" });
        String output = outputStream.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output.equals("test input file\n"));

        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        PrintStream printStream2 = new PrintStream(outputStream2);
        System.setOut(printStream2);

        Cat.cat(new String[] {});
        String output2 = outputStream2.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output2.equals(""));
    }
}