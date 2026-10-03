USE university;

-- Create a table for student records with the requested columns
CREATE TABLE student_crud (
    roll_number INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    marks DECIMAL(5, 2)
);