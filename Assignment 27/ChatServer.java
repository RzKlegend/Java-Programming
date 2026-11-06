import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3333);
            System.out.println("Server started. Waiting for a client...");
            Socket s = ss.accept();
            System.out.println("Client connected!");
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String clientMsg = "", serverMsg = "";
            while (!clientMsg.equals("stop")) {
                clientMsg = din.readUTF();
                System.out.println("Client says: " + clientMsg);
                System.out.print("Server reply: ");
                serverMsg = br.readLine();
                dout.writeUTF(serverMsg);
                dout.flush();
            }
            din.close(); s.close(); ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}