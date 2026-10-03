import java.awt.FlowLayout; //swing gui components
import java.awt.event.*; //flowlayout
import javax.swing.*; //ActionEvent and ActionListener
//Main Class
public class ButtonDemo extends JFrame implements ActionListener{
    //GUI Components
    JButton button;
    JLabel label;
    //private boolean buttonClicked = false;
    int flag = 0;

    //Constructor
    public ButtonDemo() {
        //Create Label
        label = new JLabel("click the button");
        //create button
        button = new JButton("Click MEE");
        //regular button with ActionListener
        button.addActionListener(this);
        //Set layout
        setLayout(new FlowLayout());
        //Add components in frame
        add(label);
        add(button);
        //set frame properties
        setSize(300,150);
        setTitle("bUTTON EVENT DEMO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Event Handling method
    public void actionPerformed(ActionEvent e) {
        if (flag == 0) {
        //change label when button is clicked
        label.setText("Button clicked!");
            flag = 1;
            //buttonClicked = true;
        }else{
            label.setText("Click the button again bruh");
            flag = 0;
            //buttonClicked = false;
        } 
    }
    //main method
    public static void main(String[] args) {
        //Create object of ButtonDemo
        new ButtonDemo();
    }
}