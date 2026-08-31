//1.	 Create a program to write and read employee details from a file. 31st august push
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("employee.txt");

            fw.write("Employee ID: 260\n");
            fw.write("Name: Akash\n");
            fw.write("Department: CSE\n");
            fw.write("Salary: 4567000\n");

            fw.close();

            System.out.println("Employee details written to file.");

            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nEmployee Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}