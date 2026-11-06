//server implementation
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TempServer extends UnicastRemoteObject implements TemperatureConverter {
    protected TempServer() throws RemoteException { 
        super(); 
    }
    
    public double celsiusToFahrenheit(double c) throws RemoteException {
        return (c * 9/5) + 32;
    }
    
    public double fahrenheitToCelsius(double f) throws RemoteException {
        return (f - 32) * 5/9;
    }

    public static void main(String[] args) {
        try {
            TempServer obj = new TempServer();
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("TempService", obj);
            System.out.println("Temperature Converter Server is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}