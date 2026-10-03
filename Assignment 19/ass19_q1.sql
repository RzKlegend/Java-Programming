-- Create a new database for the assignment
CREATE DATABASE university;

-- Select the database to use
USE university;

-- Create a table for student records
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    grade VARCHAR(2)
);

-- Insert dummy data to retrieve later
INSERT INTO students (id, name, course, grade) VALUES
(1, 'Akash', 'Computer Science', 'A'),
(2, 'Rohan', 'Information Technology', 'B+'),
(3, 'Priya', 'Electronics', 'A');