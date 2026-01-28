package dao;

import dto.AvailabilityDTO;
import java.util.List;

public interface AvailabilityDAO {
    boolean addAvailability(AvailabilityDTO availability);
    List<AvailabilityDTO> getAvailabilityByDoctor(int doctorId);
}
