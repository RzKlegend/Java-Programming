public class Exp3ex2 {
    // 1. Static variable to track total orders
    static int totalOrders;

    // 2. Overloaded Method for Dine-in (1 parameter)
    void calculateBill(double foodAmount) {
        totalOrders++;
        System.out.println("Dine-In Bill: Rs. " + foodAmount);
    }

    // 3. Overloaded Method for Takeaway (2 parameters)
    void calculateBill(double foodAmount, double packagingFee) {
        totalOrders++;
        double total = foodAmount + packagingFee;
        System.out.println("Takeaway Bill: Rs. " + total);
    }

    // 4. Overloaded Method for Delivery (3 parameters)
    void calculateBill(double foodAmount, double deliveryFee, double tip) {
        totalOrders++;
        double total = foodAmount + deliveryFee + tip;
        System.out.println("Delivery Bill: Rs. " + total);
    }

    public static void main(String[] args) {
        Exp3ex2 biller = new Exp3ex2();

        // Testing the overloaded methods
        biller.calculateBill(500.0); 
        biller.calculateBill(300.0, 50.0); 
        biller.calculateBill(450.0, 40.0, 20.0); 

        // Printing the static variable
        System.out.println("Total orders today: " + Exp3ex2.totalOrders);
    }
}