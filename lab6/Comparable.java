import java.util.*;

class Student implements Comparable<Student> {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}

class MarksComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.marks, s1.marks);
    }
}