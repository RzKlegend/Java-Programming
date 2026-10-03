//Create a Bank Balance Calculator GUI application using Java Swing where the user enters the initial balance and 
// transaction amount. 
// Use buttons to perform addition (deposit) and subtraction (withdrawal) and display the updated balance. 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q2 {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Bank Balance Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        
        // Use FlowLayout for simple component placement
        frame.setLayout(new FlowLayout());

        // Initialize text fields for balance and transaction amount
        JTextField balanceField = new JTextField(10);
        JTextField amountField = new JTextField(10);
        
        // Initialize buttons for deposit and withdrawal
        JButton depositButton = new JButton("Deposit (+)");
        JButton withdrawButton = new JButton("Withdrawal (-)");
        
        // Initialize a label to display the updated balance
        JLabel resultLabel = new JLabel("Updated Balance: ");

        // Action listener for Deposit (Addition)
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double currentBalance = Double.parseDouble(balanceField.getText());
                    double transactionAmount = Double.parseDouble(amountField.getText());
                    
                    // Perform addition
                    double updatedBalance = currentBalance + transactionAmount;
                    
                    resultLabel.setText("Updated Balance: " + updatedBalance);
                    // Update the balance field for subsequent transactions
                    balanceField.setText(String.valueOf(updatedBalance)); 
                    amountField.setText(""); // Clear the transaction field
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Updated Balance: Invalid Input");
                }
            }
        });

        // Action listener for Withdrawal (Subtraction)
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double currentBalance = Double.parseDouble(balanceField.getText());
                    double transactionAmount = Double.parseDouble(amountField.getText());
                    
                    // Perform subtraction
                    double updatedBalance = currentBalance - transactionAmount;
                    
                    resultLabel.setText("Updated Balance: " + updatedBalance);
                    // Update the balance field for subsequent transactions
                    balanceField.setText(String.valueOf(updatedBalance));
                    amountField.setText(""); // Clear the transaction field
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Updated Balance: Invalid Input");
                }
            }
        });

        // Add components to the frame
        frame.add(new JLabel("Initial/Current Balance:"));
        frame.add(balanceField);
        
        frame.add(new JLabel("Transaction Amount:"));
        frame.add(amountField);
        
        frame.add(depositButton);
        frame.add(withdrawButton);
        
        frame.add(resultLabel);

        // Display the window
        frame.setVisible(true);
    }
}