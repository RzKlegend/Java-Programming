 //Create a Java application to manage employee records using CRUD operations 
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assign20_Q1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";             // Your MySQL Workbench username
        String password = "akashbhavsar"; // Your MySQL Workbench password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.\n");

            // 1. CREATE (Insert) a new employee record[cite: 20]
            String insertQuery = "INSERT INTO employees (emp_id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Akash Bhavsar");
            insertStmt.setString(3, "Engineering");
            insertStmt.setDouble(4, 75291000.00);
            insertStmt.executeUpdate();
            System.out.println("--- Employee Created ---");

            // 2. READ (Select) and display employee records
            String selectQuery = "SELECT * FROM employees";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStmt.executeQuery();
            System.out.println("--- Current Employee Records ---");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("emp_id") + 
                                   " | Name: " + resultSet.getString("name") + 
                                   " | Dept: " + resultSet.getString("department") + 
                                   " | Salary: " + resultSet.getDouble("salary"));
            }
            System.out.println();

            // 3. UPDATE an existing employee record (Increase salary)[cite: 20]
            String updateQuery = "UPDATE employees SET salary = ? WHERE emp_id = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setDouble(1, 82000.00);
            updateStmt.setInt(2, 101);
            updateStmt.executeUpdate();
            System.out.println("--- Employee Salary Updated ---\n");

            // 4. DELETE the employee record[cite: 20]
            String deleteQuery = "DELETE FROM employees WHERE emp_id = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, 101);
            deleteStmt.executeUpdate();
            System.out.println("--- Employee Record Deleted ---");

            // Clean up resources
            resultSet.close();
            insertStmt.close();
            selectStmt.close();
            updateStmt.close();
            deleteStmt.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}