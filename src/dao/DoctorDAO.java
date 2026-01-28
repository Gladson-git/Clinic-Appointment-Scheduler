package dao;

import dto.DoctorDTO;
import java.util.List;

public interface DoctorDAO {
    boolean addDoctor(DoctorDTO doctor);
    List<DoctorDTO> viewAllDoctors();
}
