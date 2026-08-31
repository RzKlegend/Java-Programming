// written on 18.9.2026 as assignment was uploaded today
/*1. Create an ATM program handling invalid withdrawal amount using try-catch */
import java.util.Scanner;

public class ass14_q1 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 5000;

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                throw new Exception("Invalid withdrawal amount");
            }

            if (amount > balance) {
                throw new Exception("Insufficient balance");
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}


