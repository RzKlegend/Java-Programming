USE login_db;


CREATE TABLE hospital_staff (
    login_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
);


INSERT INTO hospital_staff (login_id, password, role) VALUES ('doc01', 'pass123', 'doctor');
INSERT INTO hospital_staff (login_id, password, role) VALUES ('nur01', 'pass456', 'nurse');