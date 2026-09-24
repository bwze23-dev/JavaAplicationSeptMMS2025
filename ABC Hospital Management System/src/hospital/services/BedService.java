package hospital.services;

import hospital.dao.BedDAO;
import hospital.models.Bed;

import java.util.List;

public class BedService {

    private final BedDAO bedDAO;

    public BedService() {
        bedDAO = new BedDAO();
    }

    public boolean addBed(Bed bed) {

        if (bed == null) {
            System.out.println("Bed cannot be null.");
            return false;
        }

        if (bed.getBedNumber() == null || bed.getBedNumber().trim().isEmpty()) {
            System.out.println("Bed number is required.");
            return false;
        }

        bedDAO.addBed(bed);
        return true;
    }

    public List<Bed> getAllBeds() {
        return bedDAO.findAllBeds();
    }

    public Bed getBedById(int bedId) {

        if (bedId <= 0) {
            System.out.println("Invalid bed ID.");
            return null;
        }

        return bedDAO.findBedById(bedId);
    }

    public List<Bed> getAvailableBeds() {
        return bedDAO.findAvailableBeds();
    }

    public List<Bed> getOccupiedBeds() {
        return bedDAO.findOccupiedBeds();
    }
}
