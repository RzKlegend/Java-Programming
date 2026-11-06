//remote interface
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureConverter extends Remote {
    double celsiusToFahrenheit(double c) throws RemoteException;
    double fahrenheitToCelsius(double f) throws RemoteException;
}