package daoimpl;

import dao.AppointmentDAO;
import dto.AppointmentDTO;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public boolean isSlotAvailable(int doctorId, Date date, Time time) {
        String sql = "SELECT * FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=? AND status='BOOKED'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setDate(2, date);
            ps.setTime(3, time);

            ResultSet rs = ps.executeQuery();
            return !rs.next(); // true if slot free

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int bookAppointment(AppointmentDTO appointment) {

        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());

            int affected = ps.executeUpdate();

            if (affected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // generated appointment_id
                }
            }

        } catch (Exception e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        String sql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByPatient(int patientId) {
        List<AppointmentDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AppointmentDTO a = new AppointmentDTO();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }

        } catch (Exception e) {
            System.out.println("Fetch Failed");
        }
        return list;
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<AppointmentDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                AppointmentDTO a = new AppointmentDTO();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }

        } catch (Exception e) {
            System.out.println("Fetch Failed");
        }
        return list;
    }
}
