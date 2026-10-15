public class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public double getMarks() { 
        return marks; 
    }

    public char getGrade() {
        if (marks >= 80) return 'A';
        if (marks >= 70) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 50) return 'D';
        return 'F';
    }


public static void main(String[] args) {

        Student s1 = new Student("Israel", 82.5);
        Student s2 = new Student("Farai", 58.0);
        Student s3 = new Student("Rudo", 42.0);

        System.out.printf("%s: Marks = %.1f | Grade = %c%n", s1.getName(), s1.getMarks(), s1.getGrade());
        System.out.printf("%s: Marks = %.1f | Grade = %c%n", s2.getName(), s2.getMarks(), s2.getGrade());
        System.out.printf("%s: Marks = %.1f | Grade = %c%n", s3.getName(), s3.getMarks(), s3.getGrade());

        System.out.println("\n--- Testing Input Validation ---");
        try {
            s1.setMarks(105.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught error: " + e.getMessage());
        }
    }
}