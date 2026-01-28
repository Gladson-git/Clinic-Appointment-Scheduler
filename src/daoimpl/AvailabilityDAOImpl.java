package daoimpl;

import dao.AvailabilityDAO;
import dto.AvailabilityDTO;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvailabilityDAOImpl implements AvailabilityDAO {

    @Override
    public boolean addAvailability(AvailabilityDTO availability) {
        String sql = "INSERT INTO availability(doctor_id, available_date, available_time) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, availability.getDoctorId());
            ps.setDate(2, availability.getAvailableDate());
            ps.setTime(3, availability.getAvailableTime());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Add Availability Failed: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<AvailabilityDTO> getAvailabilityByDoctor(int doctorId) {
        List<AvailabilityDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM availability WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AvailabilityDTO a = new AvailabilityDTO();
                a.setAvailId(rs.getInt("avail_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAvailableDate(rs.getDate("available_date"));
                a.setAvailableTime(rs.getTime("available_time"));
                list.add(a);
            }

        } catch (Exception e) {
            System.out.println("View Availability Failed: " + e.getMessage());
        }
        return list;
    }
}
