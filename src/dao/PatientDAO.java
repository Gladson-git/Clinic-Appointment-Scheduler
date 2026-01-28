package dao;

import dto.PatientDTO;

public interface PatientDAO {
    boolean registerPatient(PatientDTO patient);
    PatientDTO loginPatient(String email, String password);
}
