/* Java program to demonstrate user-defined exception
   class InvalidAgeException

class InvalidAgeException extends Exception {
    public InvalidAgeException(String m) {
        super(m);                         //message passed to constructor of parent Exception class
    }
}
//using custom exception class
public class Exp15 {
    public static void validate (int age)
    throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        } 
        System.out.println("Valid age:" + age);
}

    public static void main(String[] args) {
        try {
            validate(15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
*/

class DivideByZeroException extends Exception {
    public DivideByZeroException(String m) {
        super(m);
    }
}

public class Exp15 {
    public static void divide(int a, int b) 
    throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (DivideByZeroException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}