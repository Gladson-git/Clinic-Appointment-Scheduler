package service;

import dao.DoctorDAO;
import daoimpl.DoctorDAOImpl;
import dto.DoctorDTO;
import java.util.List;

public class AdminService {

    private DoctorDAO doctorDAO = new DoctorDAOImpl();

    public void addDoctor(DoctorDTO doctor) {
        if (doctorDAO.addDoctor(doctor))
            System.out.println("✅ Doctor Added Successfully!");
        else
            System.out.println("❌ Failed to Add Doctor");
    }

    public void viewDoctors() {
        List<DoctorDTO> list = doctorDAO.viewAllDoctors();

        System.out.println("\n--- Available Doctors ---");
        for (DoctorDTO d : list) {
            System.out.println("ID: " + d.getDoctorId() +
                               " | Name: " + d.getName() +
                               " | Specialization: " + d.getSpecialization());
        }
    }
}
