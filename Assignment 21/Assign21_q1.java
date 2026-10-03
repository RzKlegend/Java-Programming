//Create a program to connect Java with database and display database connection status. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Assign21_q1 {
    public static void main(String[] args) {
        // Database connection details (using the 'university' database from previous assignments)
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";             // Your MySQL Workbench username
        String password = "akashbhavsar"; // Your MySQL Workbench password

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish an active session with the database server using DriverManager[cite: 19]
            Connection connection = DriverManager.getConnection(url, user, password);

            // Display database connection status[cite: 19]
            if (connection != null) {
                System.out.println("Database connection status: SUCCESSFUL");
                System.out.println("Active Connection: " + connection.toString());
                
                // Clean up by closing the connection
                connection.close();
            } else {
                System.out.println("Database connection status: FAILED");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add the connector JAR.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed. Please check your MySQL server and credentials.");
            e.printStackTrace();
        }
    }
}
