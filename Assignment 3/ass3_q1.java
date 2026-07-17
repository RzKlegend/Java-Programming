public class ass3_q1 {
    // This is the static variable tracking the total number of calculations
    static int calculationCount = 0;

    // Overloaded Method 1: Addition for integers (whole numbers)
    void add(int a, int b) {
        int sum = a + b;
        calculationCount++; 
        System.out.println("Integer Addition: " + a + " + " + b + " = " + sum);
    }

    // Overloaded Method 2: Addition for decimals
    void add(double a, double b) {
        double sum = a + b;
        calculationCount++; 
        System.out.println("Decimal Addition: " + a + " + " + b + " = " + sum);
    }

    public static void main(String[] args) {
        ass3_q1 calc = new ass3_q1();
        
        // Testing the integer addition method
        calc.add(10, 25);
        calc.add(100, 200);
        
        // Testing the decimal addition method
        calc.add(15.5, 2.5);
        calc.add(10.25, 4.75);

        // Printing the static variable just like your example did
        System.out.println("Total calculations performed: " + ass3_q1.calculationCount);
    }
}