/* Q.2) Create a Driving License System that throws a custom exception if the user’s age is below 18. 
If the age is valid, display that the user is eligible for a driving license  */

// Custom exception class for invalid driving age
class InvalidDrivingAgeException extends Exception {
    public InvalidDrivingAgeException(String message) {
        super(message);
    }
}

// Main class representing the Driving License System
public class q2 {
    
    // Method to validate the applicant's age
    public static void checkEligibility(int age) throws InvalidDrivingAgeException {
        if (age < 18) {
            // Throw custom exception if age is less than 18
            throw new InvalidDrivingAgeException("Age is below 18. User is not eligible for a driving license.");
        } else {
            // Display eligibility message if age is valid
            System.out.println("Age is valid. User is eligible for a driving license.");
        }
    }

    public static void main(String[] args) {
        int[] testAges = {15, 20}; // Array to test both invalid and valid scenarios
        
        for (int age : testAges) {
            System.out.println("Checking driving license eligibility for age: " + age);
            try {
                checkEligibility(age);
            } catch (InvalidDrivingAgeException e) {
                // Handle the custom exception
                System.out.println("Exception caught: " + e.getMessage());
            }
            System.out.println("-----");
        }
    }
}