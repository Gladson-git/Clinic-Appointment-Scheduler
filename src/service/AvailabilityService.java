package service;

import dao.AvailabilityDAO;
import daoimpl.AvailabilityDAOImpl;
import dto.AvailabilityDTO;

import java.util.List;

public class AvailabilityService {

    private AvailabilityDAO availabilityDAO = new AvailabilityDAOImpl();

    public boolean addAvailability(AvailabilityDTO availability) {
        return availabilityDAO.addAvailability(availability);
    }

    public List<AvailabilityDTO> getAvailability(int doctorId) {
        return availabilityDAO.getAvailabilityByDoctor(doctorId);
    }
}