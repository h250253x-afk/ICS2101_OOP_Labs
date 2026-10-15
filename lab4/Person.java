public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {

        Student student = new Student("Israel", 20, "Computer Science");

        Teacher teacher = new Teacher("Eng. Moyo", 45, "Object-Oriented Programming");

        System.out.println("--- Student Details ---");
        student.display();

        System.out.println("\n--- Teacher Details ---");
        teacher.display();
    }
}

class Student extends Person {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Role: Student | Course: " + course);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Role: Teacher | Subject: " + subject);
    }
}
