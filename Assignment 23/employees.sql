USE login_db;
DROP TABLE employees; 

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);

INSERT INTO employees (emp_id, name, department, salary) VALUES (101, 'Aryan Kadhane', 'IT', 75000.00);
INSERT INTO employees (emp_id, name, department, salary) VALUES (102, 'Riya Bhora', 'HR', 65000.00);