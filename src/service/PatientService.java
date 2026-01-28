package service;



import dao.PatientDAO;
import daoimpl.PatientDAOImpl;
import dto.PatientDTO;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAOImpl();

    public void registerPatient(PatientDTO patient) {
        if (patientDAO.registerPatient(patient))
            System.out.println("✅ Patient Registered Successfully!");
        else
            System.out.println("❌ Registration Failed");
    }

    public PatientDTO loginPatient(String email, String password) {
        return patientDAO.loginPatient(email, password);
    }


    


}
