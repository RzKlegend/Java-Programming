// 2. Create an abstract FoodOrder class with an abstract method calculateBill(). 
// Implement two subclasses, DineInOrder and TakeAwayOrder.

abstract class FoodOrder {
    double baseAmount;

    FoodOrder(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    // Abstract method
    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    
    DineInOrder(double baseAmount) {
        super(baseAmount);
    }

    void calculateBill() {
        // Adding a flat $50 service charge for Dine-In
        double total = baseAmount + 50; 
        System.out.println("Dine-In Total Bill: $" + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    
    TakeAwayOrder(double baseAmount) {
        super(baseAmount);
    }

    void calculateBill() {
        // Adding a flat $20 packaging charge for Take-Away
        double total = baseAmount + 20; 
        System.out.println("Take-Away Total Bill: $" + total);
    }
}

public class q2 {
    public static void main(String[] args) {
        FoodOrder order1 = new DineInOrder(400);
        order1.calculateBill();

        FoodOrder order2 = new TakeAwayOrder(250);
        order2.calculateBill();
    }
}