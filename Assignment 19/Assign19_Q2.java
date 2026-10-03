// Create a Java application that connects to a database and displays product details using a SELECT query. Show product ID, product name, quantity, and price

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assign19_Q2 {
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

            // Execute the SELECT statement to retrieve product details[cite: 7]
            String query = "SELECT product_id, product_name, quantity, price FROM products";
            
            // Store the retrieved records in a ResultSet object
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("--- Product Details ---");
            
            // Allow sequential access to the data in the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                // Display product ID, product name, quantity, and price[cite: 7]
                System.out.println("ID: " + id + " | Name: " + name + " | Quantity: " + quantity + " | Price: Rs." + price);
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