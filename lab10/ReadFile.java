import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("students.txt");
        try {
            long lines;
            try (Stream<String> stream = Files.lines(path)) {
                lines = stream.count();
            }

            String content = Files.readString(path);
            long words = content.trim().isEmpty() ? 0 : content.trim().split("\\s+").length;
            long chars = content.length();

            System.out.printf("File: %s%n", path.getFileName());
            System.out.printf("Lines: %d, Words: %d, Chars: %d%n", lines, words, chars);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}