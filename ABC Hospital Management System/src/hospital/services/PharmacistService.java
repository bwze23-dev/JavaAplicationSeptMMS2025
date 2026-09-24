package hospital.services;

import hospital.dao.PharmacistDAO;
import hospital.models.Pharmacist;

import java.util.List;

public class PharmacistService {

    private final PharmacistDAO pharmacistDAO;

    public PharmacistService() {
        pharmacistDAO = new PharmacistDAO();
    }

    public boolean registerPharmacist(Pharmacist pharmacist) {

        if (pharmacist == null) {
            System.out.println("Pharmacist cannot be null.");
            return false;
        }

        if (pharmacist.getFirstName() == null || pharmacist.getFirstName().trim().isEmpty()) {
            System.out.println("First name is required.");
            return false;
        }

        pharmacistDAO.addPharmacist(pharmacist);
        return true;
    }

    public List<Pharmacist> getAllPharmacists() {
        return pharmacistDAO.findAllPharmacists();
    }

    public Pharmacist getPharmacistById(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid pharmacist/staff ID.");
            return null;
        }

        return pharmacistDAO.findPharmacistById(staffId);
    }

    public boolean deletePharmacist(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid pharmacist/staff ID.");
            return false;
        }

        return pharmacistDAO.deletePharmacist(staffId);
    }
}
