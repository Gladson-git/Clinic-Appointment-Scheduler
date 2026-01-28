package dao;

import dto.AppointmentDTO;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentDAO {

    boolean isSlotAvailable(int doctorId, Date date, Time time);

    int bookAppointment(AppointmentDTO appointment);   // returns generated ID

    boolean cancelAppointment(int appointmentId);

    List<AppointmentDTO> getAppointmentsByPatient(int patientId);

    List<AppointmentDTO> getAllAppointments();
}
