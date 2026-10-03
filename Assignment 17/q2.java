//Create a simple Employee Registration Form using Java Swing GUI that takes employee details such as Employee ID, Name, Department, and Salary. 
// Display the entered information in a dialog box 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q2 {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Employee Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        
        // Create a panel to hold and organize the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Initialize text fields for employee details
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField salaryField = new JTextField();
        
        // Add Labels and TextFields to the panel
        panel.add(new JLabel("Employee ID:"));
        panel.add(idField);
        
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        
        panel.add(new JLabel("Department:"));
        panel.add(deptField);
        
        panel.add(new JLabel("Salary:"));
        panel.add(salaryField);
        
        // Create the submit button
        JButton submitButton = new JButton("Submit");
        
        // Add button functionality to display the dialog box
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Collect the entered text
                String details = "Employee ID: " + idField.getText() + "\n"
                               + "Name: " + nameField.getText() + "\n"
                               + "Department: " + deptField.getText() + "\n"
                               + "Salary: " + salaryField.getText();
                
                // Display the details in a dialog box
                JOptionPane.showMessageDialog(frame, details, "Entered Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Add an empty space and the submit button to the last row
        panel.add(new JLabel("")); 
        panel.add(submitButton);

        // Add the panel to the frame and display it
        frame.add(panel);
        frame.setVisible(true);
    }
}
