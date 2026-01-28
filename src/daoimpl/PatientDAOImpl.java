package daoimpl;

import dao.PatientDAO;
import dto.PatientDTO;
import db.DBConnection;

import java.sql.*;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public boolean registerPatient(PatientDTO patient) {
        String sql = "INSERT INTO patients(name,email,password) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getEmail());
            ps.setString(3, patient.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Registration Failed: " + e.getMessage());
        }
        return false;
    }

    @Override
    public PatientDTO loginPatient(String email, String password) {
        String sql = "SELECT * FROM patients WHERE email=? AND BINARY password=?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                PatientDTO p = new PatientDTO();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                return p;
            }

        } catch (Exception e) {
            System.out.println("Login Failed: " + e.getMessage());
        }
        return null;
    }
}
