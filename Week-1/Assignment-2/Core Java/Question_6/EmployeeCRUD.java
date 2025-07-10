package Question_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public Employee getEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, String department) {
        Employee e = getEmployee(id);
        if (e != null) {
            e.setName(name);
            e.setDepartment(department);
        }
    }

    public void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void listAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeCRUD app = new EmployeeCRUD();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("1.Add Employee ");
            System.out.print("2.View Employee ");
            System.out.print("3.Update Employee ");
            System.out.print("4.Delete Employee ");
            System.out.print("5.List All Employees ");
            System.out.println("6.Exit ");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    app.addEmployee(new Employee(id, name, dept));
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    int viewId = Integer.parseInt(scanner.nextLine());
                    Employee e = app.getEmployee(viewId);
                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    int updId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();
                    app.updateEmployee(updId, newName, newDept);
                    break;
                case 4:
                    System.out.print("Enter id: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    app.removeEmployee(delId);
                    break;
                case 5:
                    app.listAll();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
