package Question_7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {

    public void createEmployee(Employee e) throws Exception {
        String sql = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement s = con.prepareStatement(sql)) {
            s.setInt(1, e.getId());
            s.setString(2, e.getName());
            s.setString(3, e.getDepartment());
            s.executeUpdate();
        }
    }

    public Employee readEmployee(int id) throws Exception {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement s = con.prepareStatement(sql)) {
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, String department) throws Exception {
        String sql = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement s = con.prepareStatement(sql)) {
            s.setString(1, name);
            s.setString(2, department);
            s.setInt(3, id);
            s.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws Exception {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement s = con.prepareStatement(sql)) {
            s.setInt(1, id);
            s.executeUpdate();
        }
    }

    public void displayAll() throws Exception {
        String sql = "SELECT * FROM Employee";
        try (Connection con = DBConnection.getConnection(); Statement s = con.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id") + "  " + "name:" + rs.getString("name") + "  " + "department:" + rs.getString("department"));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        EmployeeJDBC app = new EmployeeJDBC();
        Scanner scanner = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
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
                    int newId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String newDept = scanner.nextLine();
                    app.createEmployee(new Employee(newId, newName, newDept));
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    int viewId = Integer.parseInt(scanner.nextLine());
                    Employee emp = app.readEmployee(viewId);
                    if (emp != null) {
                        System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getDepartment());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    int updId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String updName = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    String updDept = scanner.nextLine();
                    app.updateEmployee(updId, updName, updDept);
                    break;
                case 4:
                    System.out.print("Enter id: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    app.deleteEmployee(delId);
                    break;
                case 5:
                    app.displayAll();
                    break;
                case 6:
                    temp = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
