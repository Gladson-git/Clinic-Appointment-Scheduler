package daoimpl;

import dao.DoctorDAO;
import dto.DoctorDTO;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public boolean addDoctor(DoctorDTO doctor) {
        String sql = "INSERT INTO doctors(name, specialization) VALUES(?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Add Doctor Failed: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<DoctorDTO> viewAllDoctors() {
        List<DoctorDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                DoctorDTO d = new DoctorDTO();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                list.add(d);
            }

        } catch (Exception e) {
            System.out.println("View Doctors Failed: " + e.getMessage());
        }
        return list;
    }
}
