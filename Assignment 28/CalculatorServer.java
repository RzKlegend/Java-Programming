//this is the server side implementation

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements Calculator {
    protected CalculatorServer() throws RemoteException { 
        super(); 
    }
    
    public int add(int a, int b) throws RemoteException { 
        return a + b; 
    }
    
    public int sub(int a, int b) throws RemoteException { 
        return a - b; 
    }

    public static void main(String[] args) {
        try {
            CalculatorServer obj = new CalculatorServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", obj);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}