USE login_db;

CREATE TABLE book_issues (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    issue_date DATE NOT NULL,
    return_date DATE NOT NULL
);