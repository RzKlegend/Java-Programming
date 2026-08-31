import java.util.Scanner;
public class ass14_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new Exception("Quantity must be greater than zero");
            }

            System.out.println("Product quantity: " + quantity);
            System.out.println("Order placed successfully");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

