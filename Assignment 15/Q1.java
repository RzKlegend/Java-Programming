import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = "9900";

        try {
            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            if (!pass.equals(password)) {
                throw new Exception("Invalid password");
            }

            System.out.println("Login successful");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Login process completed");
        }

        sc.close();
    }
}
