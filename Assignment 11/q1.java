// Assignment 11 - Exercise 1[cite: 5, 6]

interface Printable {
    void printDetails();
}

class Student implements Printable {
    public void printDetails() {
        System.out.println("Student Name: Akash Bhavsar");
        System.out.println("Course: Computer Science and Engineering");
    }
}

class Employee implements Printable {
    public void printDetails() {
        System.out.println("Employee Name: Aryan");
        System.out.println("Department: Robotics");
    }
}

// Renamed to q1 to match the q1.java file
public class q1 {
    public static void main(String[] args) {
        Student s = new Student();
        Employee e = new Employee();

        s.printDetails();
        System.out.println();

        e.printDetails();
    }
}