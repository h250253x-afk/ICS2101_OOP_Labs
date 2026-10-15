class Employee {
    private String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { 
        return name;
    }

    public double calculatePay() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }
}

class Intern extends Employee {
    private double stipendRate;

    public Intern(String name, double baseSalary, double stipendRate) {
        super(name, baseSalary);
        this.stipendRate = stipendRate;
    }

    @Override
    public double calculatePay() {
        return baseSalary * stipendRate;
    }
}

public class Payroll {
    public static void main(String[] args) {

        Employee[] staff = {
            new Employee("Israel", 2000.00),
            new Manager("Nyasha", 3500.00, 800.00),
            new Intern("Tariro", 1500.00, 0.5)
        };

        double totalPayroll = 0;
        for (Employee e : staff) {
            double pay = e.calculatePay();
            System.out.printf("%-10s pay: $%.2f%n", e.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf("%nTotal Company Payroll: $%.2f%n", totalPayroll);
    }
}