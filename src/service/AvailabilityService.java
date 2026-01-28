package service;

import dao.AvailabilityDAO;
import daoimpl.AvailabilityDAOImpl;
import dto.AvailabilityDTO;

import java.util.List;

public class AvailabilityService {

    private AvailabilityDAO availabilityDAO = new AvailabilityDAOImpl();

    public void addAvailability(AvailabilityDTO availability) {
        if (availabilityDAO.addAvailability(availability))
            System.out.println("✅ Availability Slot Added!");
        else
            System.out.println("❌ Failed to Add Slot");
    }

    public void viewAvailability(int doctorId) {
        List<AvailabilityDTO> list = availabilityDAO.getAvailabilityByDoctor(doctorId);

        System.out.println("\n--- Available Slots ---");
        for (AvailabilityDTO a : list) {
            System.out.println("Slot ID: " + a.getAvailId() +
                               " | Date: " + a.getAvailableDate() +
                               " | Time: " + a.getAvailableTime());
        }
    }
}
