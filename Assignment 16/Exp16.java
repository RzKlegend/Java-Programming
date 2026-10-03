/*
public class Exp16 {
    public static void main(String[] args) {
     try {
        //code that might throw an exception
        int[] n = new int[5];
        int divisor = 0;

        for (int i = 0; i < 10; i++) {
            int res = n[i] / divisor; // This will throw ArithmeticException
            System.out.println("Result: " + res);
     }   
    }
    catch (ArithmeticException e) {
        throw new ArithmeticException("Division by zero is not allowed.");
}
    }

}
*/ 

public class Exp16 {
    public static void main(String[] args) {
        try {
            int [] n = new int[5];
            int divisor = 0;
            
            for (int i  = 0  ; i < n.length; i++) {
                int res = n[i] / divisor;
                System.out.println(res);
            } 
        }
        catch (ArithmeticException e) {
            throw new RuntimeException("Error: Divsion by zero occurred", e);
        }
    }
}