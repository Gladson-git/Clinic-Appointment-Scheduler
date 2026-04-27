package service;

import dao.PatientDAO;
import daoimpl.PatientDAOImpl;
import dto.PatientDTO;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAOImpl();

    public boolean registerPatient(PatientDTO patient) {
        return patientDAO.registerPatient(patient);
    }

    public PatientDTO loginPatient(String email, String password) {
        return patientDAO.loginPatient(email, password);
    }
}