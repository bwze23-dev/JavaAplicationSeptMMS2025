package hospital.services;

import hospital.dao.WardDAO;
import hospital.models.Ward;

import java.util.List;

public class WardService {

    private final WardDAO wardDAO;

    public WardService() {
        wardDAO = new WardDAO();
    }

    public boolean addWard(Ward ward) {

        if (ward == null) {
            System.out.println("Ward cannot be null.");
            return false;
        }

        if (ward.getName() == null || ward.getName().trim().isEmpty()) {
            System.out.println("Ward name is required.");
            return false;
        }

        wardDAO.addWard(ward);
        return true;
    }

    public List<Ward> getAllWards() {
        return wardDAO.findAllWards();
    }

    public Ward getWardById(int wardId) {

        if (wardId <= 0) {
            System.out.println("Invalid ward ID.");
            return null;
        }

        return wardDAO.findWardById(wardId);
    }
}
