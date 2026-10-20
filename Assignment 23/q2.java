import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class q2 {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar"; 

    public static void main(String[] args) {
        // Query to retrieve specific employee columns[cite: 7]
        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Employee Records:");
            System.out.println("-------------------------------------------------");

            // Loop through the ResultSet and display records sequentially[cite: 7]
            while (rs.next()) {
                int empId = rs.getInt("emp_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID : " + empId);
                System.out.println("Name        : " + name);
                System.out.println("Department  : " + department);
                System.out.println("Salary      : ₹" + salary);
                System.out.println("-------------------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        }
    }
}