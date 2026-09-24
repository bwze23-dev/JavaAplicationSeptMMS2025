package hospital.services;

import hospital.dao.NurseAssignmentDAO;
import hospital.models.NurseAssignment;

import java.time.LocalDateTime;
import java.util.List;

public class NurseAssignmentService {

    private final NurseAssignmentDAO nurseAssignmentDAO;

    public NurseAssignmentService() {
        nurseAssignmentDAO = new NurseAssignmentDAO();
    }

    public boolean assignNurse(NurseAssignment assignment) {

        if (assignment == null) {
            System.out.println("Nurse assignment cannot be null.");
            return false;
        }

        if (assignment.getNurse() == null) {
            System.out.println("Nurse is required.");
            return false;
        }

        if (assignment.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        assignment.setStatus("ACTIVE");
        assignment.setAssignmentDate(LocalDateTime.now());
        nurseAssignmentDAO.assignNurse(assignment);
        return true;
    }

    public List<NurseAssignment> getAllNurseAssignments() {
        return nurseAssignmentDAO.findAllAssignments();
    }

    public List<NurseAssignment> getAssignmentsByPatient(int patientId) {
        return nurseAssignmentDAO.findAssignmentsByPatient(patientId);
    }

    public List<NurseAssignment> getAssignmentsByNurse(int nurseStaffId) {
        return nurseAssignmentDAO.findAssignmentsByNurse(nurseStaffId);
    }
}
