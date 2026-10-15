import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Learner(String name, int roll, double marks) {
    public String getGradeBand() {
        if (marks >= 80.0) return "A";
        if (marks >= 70.0) return "B";
        if (marks >= 60.0) return "C";
        if (marks >= 50.0) return "D";
        return "F";
    }
}

public class LearnersGrades {

    private static void ensureSampleDataExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            List<String> sampleData = List.of(
                "Israel,101,85.5",
                "Kuda,102,78.0",
                "Rudo,103,77.4",
                "Tariro,104,55.3",
                "Farai,105,45.0"
            );
            Files.write(path, sampleData);
            System.out.println("[Setup] Created 'learners.csv' with sample data.\n");
        }
    }

    public static void main(String[] args) throws IOException {

        Path path = Path.of("learners.csv");
        ensureSampleDataExists(path);

        List<Learner> learners = Files.readAllLines(path).stream()
            .filter(line -> !line.isBlank())
            .map(line -> {
                String[] p = line.split(",");
                return new Learner(p[0].trim(), Integer.parseInt(p[1].trim()), Double.parseDouble(p[2].trim()));
            })
            .toList();

        Map<String, List<Learner>> grouped = learners.stream()
            .collect(Collectors.groupingBy(Learner::getGradeBand));

        System.out.println("Generating Report Files:");
        for (var entry : grouped.entrySet()) {
            String gradeBand = entry.getKey();
            Path reportPath = Path.of("report_" + gradeBand + ".txt");

            List<String> lines = entry.getValue().stream()
                .map(l -> l.name() + "," + l.marks())
                .toList();

            Files.write(reportPath, lines);
            System.out.printf(" -> Wrote %d record(s) to %s%n", lines.size(), reportPath.getFileName());
        }

        System.out.println("\nReport generation completed successfully!");
    }
}