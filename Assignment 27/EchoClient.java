import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4444);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msg = "", echoedMsg = "";
            while (!msg.equals("stop")) {
                System.out.print("Enter message: ");
                msg = br.readLine();
                dout.writeUTF(msg);
                dout.flush();
                
                echoedMsg = din.readUTF();
                System.out.println("Echo from server: " + echoedMsg);
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}