package service;

import dao.AppointmentDAO;
import daoimpl.AppointmentDAOImpl;
import dto.AppointmentDTO;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public int bookAppointment(AppointmentDTO appointment) {

        boolean available = appointmentDAO.isSlotAvailable(
                appointment.getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime());

        if (!available) {
            return -1; // slot booked
        }

        return appointmentDAO.bookAppointment(appointment);
    }

    public boolean cancelAppointment(int appointmentId) {
        return appointmentDAO.cancelAppointment(appointmentId);
    }

    public List<AppointmentDTO> getMyAppointments(int patientId) {
        return appointmentDAO.getAppointmentsByPatient(patientId);
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}