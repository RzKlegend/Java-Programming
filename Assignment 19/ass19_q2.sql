USE university;

-- Create a table for product details
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2)
);

-- Insert dummy data to retrieve later
INSERT INTO products (product_id, product_name, quantity, price) VALUES
(101, 'Lenovo Legion Laptop', 5, 115000.00),
(102, 'Wireless Mouse', 50, 1500.00),
(103, 'Mechanical Keyboard', 20, 3500.00);