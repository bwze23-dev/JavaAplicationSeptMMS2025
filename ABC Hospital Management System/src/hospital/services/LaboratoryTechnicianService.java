package hospital.services;

import hospital.dao.LaboratoryTechnicianDAO;
import hospital.models.LaboratoryTechnician;

import java.util.List;

public class LaboratoryTechnicianService {

    private final LaboratoryTechnicianDAO laboratoryTechnicianDAO;

    public LaboratoryTechnicianService() {
        laboratoryTechnicianDAO = new LaboratoryTechnicianDAO();
    }

    public boolean registerLaboratoryTechnician(LaboratoryTechnician technician) {

        if (technician == null) {
            System.out.println("Laboratory technician cannot be null.");
            return false;
        }

        if (technician.getFirstName() == null || technician.getFirstName().trim().isEmpty()) {
            System.out.println("First name is required.");
            return false;
        }

        laboratoryTechnicianDAO.add(technician);
        return true;
    }

    public List<LaboratoryTechnician> getAllLaboratoryTechnicians() {
        return laboratoryTechnicianDAO.findAll();
    }

    public LaboratoryTechnician getLaboratoryTechnicianById(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid technician/staff ID.");
            return null;
        }

        return laboratoryTechnicianDAO.findById(staffId).orElse(null);
    }

    public boolean deleteLaboratoryTechnician(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid technician/staff ID.");
            return false;
        }

        return laboratoryTechnicianDAO.deleteById(staffId);
    }
}
