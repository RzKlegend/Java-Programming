CREATE DATABASE IF NOT EXISTS lab_db;
USE lab_db;

-- Table for Programme 1
CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);

-- Table for Programme 2
CREATE TABLE IF NOT EXISTS patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    disease VARCHAR(100),
    treatment_status VARCHAR(50)
);