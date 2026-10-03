// java applet heirarchy 
// Japplet --> applet --> panel --> container --> component --> object - here the base class is object4
// use javac to compile the program, but using applet to run/execute the program - this  is the difference bw the regular programs
/* the main methods are :-
    init() - called once the applet is initialized
    start() - called when 
    paint()
    stop()
    destroy()
*/
// Code:-

import java.applet.Applet; //capital letter Applet is a class and the rest is the package
import java.awt.Graphics;

public class MyApplet extends Applet{
    public void paint(Graphics g){
        g.drawString("Hello java",50,50);
    }
}


