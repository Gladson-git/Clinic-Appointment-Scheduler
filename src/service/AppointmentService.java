package service;

import dao.AppointmentDAO;
import daoimpl.AppointmentDAOImpl;
import dto.AppointmentDTO;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public void bookAppointment(AppointmentDTO appointment) {

        boolean available = appointmentDAO.isSlotAvailable(
                appointment.getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime());

        if (!available) {
            System.out.println("❌ Slot Already Booked!");
            return;
        }

        int id = appointmentDAO.bookAppointment(appointment);

        if (id > 0)
            System.out.println("✅ Appointment Booked Successfully! Your Appointment ID is: " + id);
        else
            System.out.println("❌ Booking Failed");
    }

    public void cancelAppointment(int appointmentId) {
        if (appointmentDAO.cancelAppointment(appointmentId))
            System.out.println("✅ Appointment Cancelled");
        else
            System.out.println("❌ Cancellation Failed");
    }

    public void viewMyAppointments(int patientId) {
        List<AppointmentDTO> list = appointmentDAO.getAppointmentsByPatient(patientId);

        System.out.println("\n--- My Appointments ---");
        for (AppointmentDTO a : list) {
            System.out.println("ID: " + a.getAppointmentId() +
                    " | Doctor ID: " + a.getDoctorId() +
                    " | Date: " + a.getAppointmentDate() +
                    " | Time: " + a.getAppointmentTime() +
                    " | Status: " + a.getStatus());
        }
    }

    public void viewAllAppointments() {
        List<AppointmentDTO> list = appointmentDAO.getAllAppointments();

        System.out.println("\n--- All Appointments ---");
        for (AppointmentDTO a : list) {
            System.out.println("ID: " + a.getAppointmentId() +
                    " | Patient ID: " + a.getPatientId() +
                    " | Doctor ID: " + a.getDoctorId() +
                    " | Date: " + a.getAppointmentDate() +
                    " | Time: " + a.getAppointmentTime() +
                    " | Status: " + a.getStatus());
        }
    }
}
