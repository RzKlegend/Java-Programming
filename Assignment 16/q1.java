//q.1 Create a Voting System that throws a custom exception if age is below 18 
// 
// Custom exception class for invalid age
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// the main class representing the Voting System
public class q1 {
    
    // method to validate the voter's age
    public static void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw custom exception if age is less than 18
            throw new InvalidAgeException("Age is below 18. User is not eligible to vote.");
        } else {
            System.out.println("Age is valid. User is eligible to vote.");
        }
    }

    public static void main(String[] args) {
        int[] testAges = {16, 21}; // Array to test both of the scenarios
        
        for (int age : testAges) {
            System.out.println("Checking eligibility for age: " + age);
            try {
                checkEligibility(age);
            } catch (InvalidAgeException e) {
                // Handle the custom exception
                System.out.println("Exception caught: " + e.getMessage());
            }
            System.out.println("------");
        }
    }
}
