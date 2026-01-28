🏥 Clinic Appointment Scheduler

A Command-Line Based Clinic Appointment Scheduler built using Java, JDBC, and MySQL, following a clean DTO → DAO → Service → Main layered architecture.
The system allows patients to register, log in, view doctors, check availability, book appointments with double-booking prevention, cancel appointments, and allows admins to manage doctors, availability, and view reports.

🚀 Features
👤 Patient Module

Patient Registration & Login

Case-sensitive password authentication

View available doctors

View doctor availability slots

Book appointments

Prevents double-booking of same slot

View own appointments

Cancel appointments using Appointment ID

👨‍⚕️ Admin Module

Add new doctors

View all doctors

Add doctor availability slots

View all appointments

🛠️ Technologies Used

Java (JDK 17+)

JDBC

MySQL

VS Code

MySQL Connector/J


🏗️ Project Architecture

src
 ├── dto        → Data Transfer Objects
 ├── dao        → DAO Interfaces
 ├── daoimpl   → DAO Implementations
 ├── service   → Business Logic Layer
 ├── db        → Database Connection
 └── main      → Main CLI Application

Architecture Pattern:

DTO → DAO → DAOImpl → Service → Main

🗄️ Database Schema

CREATE DATABASE clinic_scheduler;
USE clinic_scheduler;

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE availability (
    avail_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT,
    available_date DATE,
    available_time TIME,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    status VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);


⚙️ Setup Instructions
1️⃣ Prerequisites

JDK 17 or above

MySQL Server

MySQL Connector/J

VS Code with Java Extension Pack

2️⃣ Database Setup

Open MySQL Command Line:

CREATE DATABASE clinic_scheduler;
Run the table creation script provided above.

3️⃣ Configure Database Connection

Edit:
src/db/DBConnection.java

Update:
private static final String USER = "root";
private static final String PASS = "xxxxxxxx";

4️⃣ Add MySQL Connector JAR

Place:

mysql-connector-j-9.x.x.jar

inside lib/ folder and add it to VS Code Java Classpath.

5️⃣ Run the Project

Run:
src/main/ClinicMain.java

🧪 Key Functional Highlights

Case-sensitive login using MySQL BINARY comparison

Doctor availability scheduling

Appointment booking with conflict prevention

Auto-generated Appointment ID returned to patient

Appointment cancellation with status update

📋 Sample Flow
Main Menu
1. Patient Registration
2. Patient Login
3. Admin Login

Patient Menu
- View Doctors
- View Availability
- Book Appointment
- View My Appointments
- Cancel Appointment

Admin Menu
- Add Doctor
- Add Availability
- View All Appointments

🎯 Resume Project Description

Clinic Appointment Scheduler – Java, JDBC, MySQL

Developed a command-line based clinic management system allowing patients to register, log in, view doctor availability, and book or cancel appointments. Implemented conflict-free appointment scheduling, case-sensitive authentication, and admin reporting using Java, JDBC, and MySQL with layered DTO–DAO–Service architecture.


👨‍💻 Author

Gladson K

🌟 Future Enhancements

Password hashing for better security

Input validation

GUI using JavaFX

REST API using Spring Boot

✅ Project Status

Completed and Fully Functional
