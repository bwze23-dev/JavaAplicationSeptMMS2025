package hospital.services;

import hospital.dao.NurseDAO;
import hospital.models.Nurse;

import java.util.List;

public class NurseService {

    private final NurseDAO nurseDAO;

    public NurseService() {
        nurseDAO = new NurseDAO();
    }

    // =========================================================
    // REGISTER NURSE
    // =========================================================

    public boolean registerNurse(Nurse nurse) {

        if (nurse == null) {
            System.out.println("Nurse cannot be null.");
            return false;
        }

        if (nurse.getFirstName() == null || nurse.getFirstName().trim().isEmpty()) {
            System.out.println("First name is required.");
            return false;
        }

        if (nurse.getLastName() == null || nurse.getLastName().trim().isEmpty()) {
            System.out.println("Last name is required.");
            return false;
        }

        return nurseDAO.addNurse(nurse);
    }

    // =========================================================
    // GET ALL NURSES
    // =========================================================

    public List<Nurse> getAllNurses() {
        return nurseDAO.findAllNurses();
    }

    // =========================================================
    // GET NURSE BY ID
    // =========================================================

    public Nurse getNurseById(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid nurse/staff ID.");
            return null;
        }

        return nurseDAO.findNurseById(staffId);
    }

    // =========================================================
    // UPDATE NURSE
    // =========================================================

    public boolean updateNurse(Nurse nurse) {

        if (nurse == null) {
            System.out.println("Nurse cannot be null.");
            return false;
        }

        if (nurse.getStaffID() <= 0) {
            System.out.println("Invalid nurse/staff ID.");
            return false;
        }

        return nurseDAO.update(nurse);
    }

    // =========================================================
    // DELETE NURSE
    // =========================================================

    public boolean deleteNurse(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid nurse/staff ID.");
            return false;
        }

        return nurseDAO.delete(staffId);
    }
}
