import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SaveRead {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("output.txt");
        List<String> lines = List.of("Line 1", "Line 2", "Line 3", "Line 4", "Line 5");
        Files.write(path, lines);
        List<String> read = Files.readAllLines(path);
        read.forEach(System.out::println);
    }
}