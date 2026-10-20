//  the first code is for the arithmetic exception and the second code is for the null pointer exception
/* 
public class Exp11 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
    
    try {
        int result = num1 / num2;
        System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
       System.out.println("Error: Division by zero is not allowed.");
        System.out.println("Exception message: " + e.getMessage()); 
    }
    System.out.println("Program continues after exception handling.");
  }
}
*/

// this code is for multiple catch blocks and the first catch block is for the null pointer exception and 
// the second catch block is for the other unexpected exception  
/* 
public class Exp11 {
    public static void main(String[] args) {
    try {
        String str = null;
        System.out.println(str.length());
    } catch (NullPointerException e) {
        System.out.println("Error: Null pointer exception occurred.");
    } catch (Exception e) {
        System.out.println("Error: An other unexpected exception occurred.");
        System.out.println("Exception message: " + e.getMessage());
    }
        System.out.println("Program continues after exception handling.");
}
}
*/

//This code is for multiple catch blocks and the first catch block is for the null pointer exception and the second catch
//  block is for the arithmetic exception and the third catch block is for the other unexpected exception

public class Exp13 {
    public static void main(String[] args) {
     try {
        int a = 10;
        int b = 0;
    } catch (NullPointerException e) {
        System.out.println("Error: Null pointer exception occurred.");
    } catch (ArithmeticException e) {
        System.out.println("Error: Arithmetic exception occurred.");
    } catch (Exception e) {
        System.out.println("Error: An other unexpected exception occurred.");
        System.out.println("Exception message: " + e.getMessage());
    }
    
    finally {
        System.out.println("Program continues after exception handling.");
    }
}
}