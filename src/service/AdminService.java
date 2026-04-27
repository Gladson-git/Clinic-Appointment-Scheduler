package service;

import dao.DoctorDAO;
import daoimpl.DoctorDAOImpl;
import dto.DoctorDTO;
import java.util.List;

public class AdminService {

    private DoctorDAO doctorDAO = new DoctorDAOImpl();

    public boolean addDoctor(DoctorDTO doctor) {
        return doctorDAO.addDoctor(doctor);
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorDAO.viewAllDoctors();
    }
}