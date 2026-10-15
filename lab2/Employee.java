public class Employee {
    private static int employeeCount = 0;
    private String name;
    private final int employeeId;
    private double salary;

    public Employee(String name, double salary) {
        Employee.employeeCount++;
        this.employeeId = Employee.employeeCount;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name) {
        this(name, 0.0);
    }

    public Employee() {
        this("Unknown", 0.0);
    }

    public Employee(Employee other) {
        this(other.name, other.salary);
    }

    public void display() {
        System.out.printf("ID: #%d | Name: %-10s | Salary: $%.2f%n", employeeId, name, salary);
    }

    public static void main(String[] args) {
        
        Employee emp1 = new Employee("Tariro", 45000.00);

        Employee emp2 = new Employee("Farai");

        Employee emp3 = new Employee();

        Employee emp4 = new Employee(emp1);

        emp1.display();
        emp2.display();
        emp3.display();
        emp4.display();

        System.out.println("\nTotal Employees Created: " + employeeCount);
    }

    public double calculatePay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }
}
