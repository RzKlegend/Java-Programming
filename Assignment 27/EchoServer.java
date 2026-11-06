import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4444);
            System.out.println("Echo Server started...");
            Socket s = ss.accept();
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            String msg = "";
            while (!msg.equals("stop")) {
                msg = din.readUTF();
                dout.writeUTF(msg); // Echoing back the same message
                dout.flush();
            }
            s.close(); ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}