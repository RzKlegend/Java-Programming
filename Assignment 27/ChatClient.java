import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3333);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String clientMsg = "", serverMsg = "";
            while (!clientMsg.equals("stop")) {
                System.out.print("Enter message (type 'stop' to exit): ");
                clientMsg = br.readLine();
                dout.writeUTF(clientMsg);
                dout.flush();
                serverMsg = din.readUTF();
                System.out.println("Server says: " + serverMsg);
            }
            dout.close(); s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}