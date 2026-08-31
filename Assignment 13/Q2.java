import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("patient.txt");

            fw.write("Patient ID: 260\n");
            fw.write("Name: Akash\n");
            fw.write("Age: 19\n");
            fw.write("Disease: Cold\n");

            fw.close();

            System.out.println("Patient details written to file.");

            FileReader fr = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nPatient Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


