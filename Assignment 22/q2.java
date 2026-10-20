import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class q2 {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Query fetches the role to determine the access message
        String query = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, loginId);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    
                    // Display appropriate access messages based on authentication result
                    if (role.equalsIgnoreCase("doctor")) {
                        System.out.println("Login Successful! Welcome, Doctor. You have access to patient medical records and prescriptions.");
                    } else if (role.equalsIgnoreCase("nurse")) {
                        System.out.println("Login Successful! Welcome, Nurse. You have access to patient vitals and ward schedules.");
                    }
                } else {
                    System.out.println("Login Failed! Invalid login ID or password.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}