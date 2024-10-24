-- Create Patients Table
CREATE TABLE Patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    address VARCHAR(255),
    phone VARCHAR(15)
);

-- Create Doctors Table
CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialty VARCHAR(100),
    department VARCHAR(100)
);

-- Create Staff Table
CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    role VARCHAR(100),
    department VARCHAR(100)
);

-- Create Appointments Table
CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id) ON DELETE CASCADE
);

-- Create Billing Table
CREATE TABLE Billing (
    billing_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    amount DECIMAL(10, 2),
    payment_status VARCHAR(50),
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id) ON DELETE CASCADE
);

-- Insert Sample Data into Patients Table
INSERT INTO Patients (name, age, phone, address) VALUES
('John Doe', 45, '1234567890', '123 Main St'),
('Jane Smith', 32, '0987654321', '456 Maple Ave'),
('Robert Brown', 28, '1122334455', '789 Oak Dr');

-- Insert Sample Data into Doctors Table
INSERT INTO Doctors (name, specialty, phone, department) VALUES
('Dr. Alice Green', 'Cardiology', '5551112222', 'Cardiology'),
('Dr. Bob White', 'Dermatology', '5553334444', 'Dermatology'),
('Dr. Carol Black', 'Pediatrics', '5555556666', 'Pediatrics');

-- Insert Sample Data into Staff Table
INSERT INTO Staff (name, role, department) VALUES
('Mark Johnson', 'Nurse', 'Emergency'),
('Lucy Adams', 'Receptionist', 'Front Desk'),
('Emma Wilson', 'Technician', 'Radiology');

-- Insert Sample Data into Appointments Table
INSERT INTO Appointments (patient_id, doctor_id, appointment_date) VALUES
(1, 1, '2024-10-20'),
(2, 2, '2024-10-21'),
(3, 3, '2024-10-22');

-- Insert Sample Data into Billing Table
INSERT INTO Billing (patient_id, amount, payment_status) VALUES
(1, 250.00, 'Paid'),
(2, 175.50, 'Pending'),
(3, 300.75, 'Paid');
