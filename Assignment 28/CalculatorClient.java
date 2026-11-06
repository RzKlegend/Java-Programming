//the client side of implementation

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("CalculatorService");
            
            System.out.println("Addition (10 + 5): " + stub.add(10, 5));
            System.out.println("Subtraction (10 - 5): " + stub.sub(10, 5));
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}