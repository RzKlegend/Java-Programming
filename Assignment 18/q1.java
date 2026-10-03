//Create a GUI calculator where buttons perform addition and subtraction. 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q1 {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("GUI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        
        // Use a simple FlowLayout for the components
        frame.setLayout(new FlowLayout());

        // Initialize text fields for user input
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        
        // Initialize buttons for addition and subtraction
        JButton addButton = new JButton("Add (+)");
        JButton subButton = new JButton("Subtract (-)");
        
        // Initialize a label to display the result
        JLabel resultLabel = new JLabel("Result: ");

        // Add an ActionListener to handle addition
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double sum = num1 + num2;
                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Result: Invalid Input");
                }
            }
        });

        // Add an ActionListener to handle subtraction
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double difference = num1 - num2;
                    resultLabel.setText("Result: " + difference);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Result: Invalid Input");
                }
            }
        });

        // Add all components to the frame
        frame.add(new JLabel("Number 1:"));
        frame.add(num1Field);
        
        frame.add(new JLabel("Number 2:"));
        frame.add(num2Field);
        
        frame.add(addButton);
        frame.add(subButton);
        
        frame.add(resultLabel);

        // Display the window
        frame.setVisible(true);
    }
}