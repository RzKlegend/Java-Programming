//Create a Java program to connect with a database and display the connection status. 
// After successful connection, show a message indicating that the Student database is connected successfully. 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Assign21_q2 {
    public static void main(String[] args) {
        // Database connection details (Using your existing university database)
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";             // Your MySQL Workbench username
        String password = "akashbhavsar"; // Your MySQL Workbench password

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish communication with the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Display database connection status[cite: 19]
            if (connection != null) {
                System.out.println("Connection status: SUCCESSFUL");
                
                // Show the specific message required by the assignment[cite: 19]
                System.out.println("Student database is connected successfully.");
                
                // Clean up by closing the connection
                connection.close();
            } else {
                System.out.println("Connection status: FAILED");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add the connector JAR to Referenced Libraries.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed. Please check your credentials.");
            e.printStackTrace();
        }
    }
}