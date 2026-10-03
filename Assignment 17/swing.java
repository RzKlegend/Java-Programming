import javax.swing.JButton; //swing gui components
import javax.swing.JFrame;

public class swing{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My application");

        JButton button = new JButton("Click me");
        frame.add(button);

        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}