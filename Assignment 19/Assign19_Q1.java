//Create a Java application to display student records from database using SELECT query 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assign19_Q1 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";             // Your MySQL Workbench username
        String password = "akashbhavsar"; // Your MySQL Workbench password

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish an active connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a Statement object to execute SQL queries
            Statement statement = connection.createStatement();

            // Execute the SELECT statement to retrieve student records
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("--- Student Records ---");
            
            // Loop through the results and print them
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                String grade = resultSet.getString("grade");

                System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course + " | Grade: " + grade);
            }

            // Clean up resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Please add the connector JAR to your project.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection or query failed.");
            e.printStackTrace();
        }
    }
}