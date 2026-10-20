import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class q2_exp24 {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "akashbhavsar";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Issue Tracking System");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel for record management
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        JTextField bookIdField = new JTextField();
        inputPanel.add(bookIdField);

        inputPanel.add(new JLabel("Student Name:"));
        JTextField studentField = new JTextField();
        inputPanel.add(studentField);

        inputPanel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        JTextField issueDateField = new JTextField();
        inputPanel.add(issueDateField);

        inputPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        JTextField returnDateField = new JTextField();
        inputPanel.add(returnDateField);

        JButton issueButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View Records");
        inputPanel.add(issueButton);
        inputPanel.add(viewButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table to display the issued books
        String[] columns = {"Issue ID", "Book ID", "Student Name", "Issue Date", "Return Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Action to insert records into the database
        issueButton.addActionListener(e -> {
            String query = "INSERT INTO book_issues (book_id, student_name, issue_date, return_date) VALUES (?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setInt(1, Integer.parseInt(bookIdField.getText()));
                pstmt.setString(2, studentField.getText());
                pstmt.setDate(3, java.sql.Date.valueOf(issueDateField.getText()));
                pstmt.setDate(4, java.sql.Date.valueOf(returnDateField.getText()));
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(frame, "Book Issued Successfully!");
                bookIdField.setText(""); studentField.setText(""); 
                issueDateField.setText(""); returnDateField.setText("");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Database Error!");
                ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, "Please ensure dates are in YYYY-MM-DD format and Book ID is a number.");
            }
        });

        // Action to retrieve and display records
        viewButton.addActionListener(e -> {
            model.setRowCount(0); 
            String query = "SELECT * FROM book_issues";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("issue_id"), 
                        rs.getInt("book_id"), 
                        rs.getString("student_name"), 
                        rs.getDate("issue_date"), 
                        rs.getDate("return_date")
                    });
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error fetching records.");
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}