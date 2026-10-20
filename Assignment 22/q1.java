import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class q1 {
    // Update these with your local database configuration
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Parameterized query to prevent SQL injection
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Bind the user input to the query placeholders (?)
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the SELECT query and store results
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login Successful! Welcome, " + username + ".");
                } else {
                    System.out.println("Login Failed! Invalid username or password.");
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