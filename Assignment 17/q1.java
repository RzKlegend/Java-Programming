/*1. Create a simple Student Registration Form GUI using Swing.  */

/*Theory Swing is Java's GUI toolkit that provides lightweight components such as buttons, labels, text fields, and menus. 
Applets were small Java programs embedded in web pages for interactive applications. 
Although Applets are obsolete, Swing remains an important framework for desktop application development. 
Swing supports platform-independent graphical interfaces.  */

import java.awt.*;
import javax.swing.*;

public class q1 {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Student Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create a panel to hold and organize the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Add Labels and TextFields directly to the panel
        panel.add(new JLabel("Student Name:"));
        panel.add(new JTextField());
        
        panel.add(new JLabel("Roll Number:"));
        panel.add(new JTextField());
        
        panel.add(new JLabel("Course:"));
        panel.add(new JTextField());
        
        // Add an empty space and the Register button
        panel.add(new JLabel("")); 
        panel.add(new JButton("Register"));

        // Add the panel to the frame and display it
        frame.add(panel);
        frame.setVisible(true);
    }
}