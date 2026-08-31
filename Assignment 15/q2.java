import java.util.Scanner;

public class q2 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correctPin = 9900;

        try {
            System.out.print("Enter your ATM PIN: ");
            int pin = sc.nextInt();

            if (pin != correctPin) {
                throw new Exception("Invalid PIN");
            }

            System.out.println("PIN verified successfully");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("PIN verification process completed");
        }

        sc.close();
    }
}
