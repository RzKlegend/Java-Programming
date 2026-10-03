//Create a Java application to manage student records using CRUD operations. 
// Perform Create, Read, Update, and Delete operations on student details such as roll number, name, course, and
//  marks using a database. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assign20_Q2 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";             // Your MySQL Workbench username
        String password = "akashbhavsar"; // Your MySQL Workbench password

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.\n");

            // 1. CREATE (Insert) a new student record[cite: 15]
            String insertQuery = "INSERT INTO student_crud (roll_number, name, course, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Akash Bhavsar");
            insertStmt.setString(3, "Computer Science");
            insertStmt.setDouble(4, 88.50);
            insertStmt.executeUpdate();
            System.out.println("--- Student Record Created ---");

            // 2. READ (Select) and display student records[cite: 15]
            String selectQuery = "SELECT * FROM student_crud";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStmt.executeQuery();
            System.out.println("--- Current Student Records ---");
            while (resultSet.next()) {
                System.out.println("Roll No: " + resultSet.getInt("roll_number") + 
                                   " | Name: " + resultSet.getString("name") + 
                                   " | Course: " + resultSet.getString("course") + 
                                   " | Marks: " + resultSet.getDouble("marks"));
            }
            System.out.println();

            // 3. UPDATE an existing student record (Change marks)[cite: 15]
            String updateQuery = "UPDATE student_crud SET marks = ? WHERE roll_number = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setDouble(1, 95.00); // Updating marks to 95
            updateStmt.setInt(2, 101);      // For roll number 101
            updateStmt.executeUpdate();
            System.out.println("--- Student Marks Updated ---\n");

            // 4. DELETE the student record[cite: 15]
            String deleteQuery = "DELETE FROM student_crud WHERE roll_number = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, 101);
            deleteStmt.executeUpdate();
            System.out.println("--- Student Record Deleted ---");

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