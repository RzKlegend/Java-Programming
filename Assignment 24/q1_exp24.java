import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class q1_exp24 {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar";

    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the input panel with labels and text fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        JTextField idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Book Title:"));
        JTextField titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField();
        inputPanel.add(authorField);

        // Create buttons
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        inputPanel.add(addButton);
        inputPanel.add(viewButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Create the table to display records
        String[] columns = {"Book ID", "Title", "Author"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Action for "Add Book" button
        addButton.addActionListener(e -> {
            String query = "INSERT INTO books (book_id, title, author) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setInt(1, Integer.parseInt(idField.getText()));
                pstmt.setString(2, titleField.getText());
                pstmt.setString(3, authorField.getText());
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(frame, "Book Added Successfully!");
                idField.setText(""); titleField.setText(""); authorField.setText(""); // Clear fields
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Database Error!");
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Book ID.");
            }
        });

        // Action for "View Books" button
        viewButton.addActionListener(e -> {
            model.setRowCount(0); // Clear the table before loading new data
            String query = "SELECT * FROM books";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getInt("book_id"), rs.getString("title"), rs.getString("author")});
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error fetching books.");
                ex.printStackTrace();
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}