package Exercise_4_Employee_Management_System;

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
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManagement {
    static final int MAX = 100;
    static Employee[] employeeArray = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(Employee emp) {
        if (count < MAX) {
            employeeArray[count++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employeeArray[i].employeeId == id) {
                return employeeArray[i];
            }
        }
        return null;
    }

    public static void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employeeArray[i]);
            }
        }
    }

    public static void deleteEmployee(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employeeArray[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employeeArray[j] = employeeArray[j + 1];
                }
                employeeArray[--count] = null;
                found = true;
                System.out.println("Employee deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        EmployeeManagement.addEmployee(new Employee(101, "Vishwa", "Manager", 80000));
        EmployeeManagement.addEmployee(new Employee(102, "Nawin", "Developer", 60000));
        EmployeeManagement.addEmployee(new Employee(103, "Raja", "Tester", 50000));

        System.out.println("\nAll Employees:");
        EmployeeManagement.displayEmployees();

        System.out.println("\nSearching for employee with ID 102:");
        Employee found = EmployeeManagement.searchEmployee(102);
        System.out.println(found != null ? found : "Not found.");

        System.out.println("\nDeleting employee with ID 101:");
        EmployeeManagement.deleteEmployee(101);

        System.out.println("\nEmployees after deletion:");
        EmployeeManagement.displayEmployees();
    }
}
