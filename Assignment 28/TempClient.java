//client implementation
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TempClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);
            TemperatureConverter stub = (TemperatureConverter) registry.lookup("TempService");
            
            System.out.println("25.0 Celsius to Fahrenheit: " + stub.celsiusToFahrenheit(25.0));
            System.out.println("98.6 Fahrenheit to Celsius: " + stub.fahrenheitToCelsius(98.6));
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}