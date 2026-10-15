import java.util.List;
import java.util.stream.Collectors;

record Student(String name, double marks) {}

public class StudentGrades {
    public static void main(String[] args) {

        List<Student> students = List.of(
            new Student("Israel", 85.5),
            new Student("Rudo", 78.0),
            new Student("Kuda", 77.4),
            new Student("James", 55.3)
        );

        double avg = students.stream()
                .mapToDouble(Student::marks)
                .average()
                .orElse(0.0);

        System.out.printf("Average Mark: %.2f%n", avg);

        List<String> aboveAvg = students.stream()
                .filter(s -> s.marks() > avg)
                .map(Student::name)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Students above average: " + aboveAvg);
    }
}

