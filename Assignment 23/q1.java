import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class q1 {
    // Database credentials using your existing setup
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar"; 

    public static void main(String[] args) {
        String query = "SELECT id, username FROM users";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             // Executing the query returns a ResultSet object containing the data[cite: 7]
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Displaying user records one by one:");
            System.out.println("-----------------------------------");

            // next() moves the cursor forward one row at a time[cite: 7]
            while (rs.next()) {
                // Retrieving data from each column using getInt() and getString()[cite: 7]
                int id = rs.getInt("id");
                String username = rs.getString("username");

                System.out.println("User ID: " + id + " | Username: " + username);
            }
            
            System.out.println("-----------------------------------");
            System.out.println("End of records.");

        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        }
    }
}