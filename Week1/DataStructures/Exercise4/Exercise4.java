package Week1.DataStructures.Exercise4;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee e) {
        if (count >= employees.length) {
            System.out.println("Array full. Cannot add more employees.");
            return;
        }
        employees[count++] = e;
        System.out.println("Employee added");
    }

    // Search Employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1]; // shift left
                }
                employees[--count] = null;
                System.out.println("Employee deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Engineer", 60000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 80000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        System.out.println("\nAll Employees:");
        manager.displayEmployees();

        System.out.println("\nSearching for ID 2:");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting ID 2:");
        manager.deleteEmployee(2);

        System.out.println("\nAll Employees after deletion:");
        manager.displayEmployees();
    }
}
