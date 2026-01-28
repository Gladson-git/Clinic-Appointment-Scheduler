package main;

import dto.*;
import service.*;

import java.util.Scanner;

public class ClinicMain {

    static Scanner sc = new Scanner(System.in);

    static PatientService patientService = new PatientService();
    static AdminService adminService = new AdminService();
    static AvailabilityService availabilityService = new AvailabilityService();
    static AppointmentService appointmentService = new AppointmentService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== CLINIC APPOINTMENT SCHEDULER =====");
            System.out.println("1. Patient Registration");
            System.out.println("2. Patient Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> registerPatient();
                case 2 -> patientLogin();
                case 3 -> adminMenu();
                case 4 -> {
                    System.out.println("Thank You!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    // ---------------- PATIENT FUNCTIONS ----------------

    private static void registerPatient() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        PatientDTO patient = new PatientDTO(name, email, pass);
        patientService.registerPatient(patient);
    }

    private static void patientLogin() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        PatientDTO patient = patientService.loginPatient(email, pass);

        if (patient != null) {
            System.out.println("✅ Login Successful! Welcome " + patient.getName());
            patientMenu(patient);
        } else {
            System.out.println("❌ Invalid Credentials");
        }
    }

    private static void patientMenu(PatientDTO patient) {
        while (true) {
            System.out.println("\n===== PATIENT MENU =====");
            System.out.println("1. View Doctors");
            System.out.println("2. View Doctor Availability");
            System.out.println("3. Book Appointment");
            System.out.println("4. View My Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> adminService.viewDoctors();
                case 2 -> viewAvailability();
                case 3 -> bookAppointment(patient);
                case 4 -> appointmentService.viewMyAppointments(patient.getPatientId());
                case 5 -> cancelAppointment();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void viewAvailability() {
        System.out.print("Enter Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();
        availabilityService.viewAvailability(docId);
    }

    private static void bookAppointment(PatientDTO patient) {
        System.out.print("Enter Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();

        System.out.print("Enter Time (HH:MM): ");
        String timeStr = sc.nextLine() + ":00";

        java.sql.Date date = java.sql.Date.valueOf(dateStr);
        java.sql.Time time = java.sql.Time.valueOf(timeStr);

        AppointmentDTO appointment = new AppointmentDTO(patient.getPatientId(), docId, date, time, "BOOKED");

        appointmentService.bookAppointment(appointment);
    }

    private static void cancelAppointment() {
        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        appointmentService.cancelAppointment(id);
    }

    // ---------------- ADMIN FUNCTIONS ----------------

    private static void adminMenu() {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Add Doctor Availability");
            System.out.println("4. View All Appointments");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> addDoctor();
                case 2 -> adminService.viewDoctors();
                case 3 -> addAvailability();
                case 4 -> appointmentService.viewAllAppointments();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void addDoctor() {
        System.out.print("Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        DoctorDTO doctor = new DoctorDTO(name, spec);
        adminService.addDoctor(doctor);
    }

    private static void addAvailability() {
        System.out.print("Enter Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();

        System.out.print("Enter Time (HH:MM): ");
        String timeStr = sc.nextLine() + ":00";

        java.sql.Date date = java.sql.Date.valueOf(dateStr);
        java.sql.Time time = java.sql.Time.valueOf(timeStr);

        AvailabilityDTO availability = new AvailabilityDTO(docId, date, time);
        availabilityService.addAvailability(availability);
    }
}
