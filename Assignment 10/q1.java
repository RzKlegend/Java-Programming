// Assignment 10 - Exercise 1 
//1.Create an abstract Payment class and implement Credit Card and UPI payment classes.

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method - must be implemented by subclasses 
    abstract void processPayment();

    // Concrete method shared by all payments
    public void displayAmount() {
        System.out.println("Total Amount: $" + amount);
    }
}

// Concrete subclass: CreditCardPayment
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    void processPayment() {
        System.out.println("Processing Credit Card payment of $" + amount + " for holder " + cardHolderName + " (Card: " + cardNumber + ")");
    }
}

// C1oncrete subclass: UPIPayment 
class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    void processPayment() {
        System.out.println("Processing UPI payment of $" + amount + " via UPI ID: " + upiId);
    }
}

public class q1 {
    public static void main(String[] args) {
        // polymorphism using the abstract class reference
        Payment p1 = new CreditCardPayment(2492.50, "112119222033338898", "Akash Bhavsar");
        p1.displayAmount();
        p1.processPayment();

        System.out.println("-------------");

        Payment p2 = new UPIPayment(110.00, "akash@okhsbc");
        p2.displayAmount();
        p2.processPayment();
    }
}