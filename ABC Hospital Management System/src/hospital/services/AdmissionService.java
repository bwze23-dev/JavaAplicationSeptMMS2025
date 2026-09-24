package hospital.services;

import hospital.dao.AdmissionDAO;
import hospital.dao.BedDAO;
import hospital.models.Admission;

import java.time.LocalDate;
import java.util.List;

public class AdmissionService {

    private final AdmissionDAO admissionDAO;
    private final BedDAO bedDAO;

    public AdmissionService() {
        admissionDAO = new AdmissionDAO();
        bedDAO = new BedDAO();
    }

    public boolean admitPatient(Admission admission) {

        if (admission == null) {
            System.out.println("Admission cannot be null.");
            return false;
        }

        if (admission.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (admission.getBed() == null) {
            System.out.println("Bed is required.");
            return false;
        }

        if (!"AVAILABLE".equalsIgnoreCase(admission.getBed().getStatus())) {
            System.out.println("Selected bed is not available.");
            return false;
        }

        admission.setStatus("ACTIVE");
        admission.setAdmissionDate(LocalDate.now());
        admissionDAO.admitPatient(admission);
        admission.getBed().setStatus("OCCUPIED");
        return true;
    }

    public List<Admission> getAllAdmissions() {
        return admissionDAO.findAllAdmissions();
    }

    public Admission getAdmissionById(int admissionId) {

        if (admissionId <= 0) {
            System.out.println("Invalid admission ID.");
            return null;
        }

        return admissionDAO.findAdmissionById(admissionId);
    }

    public boolean updateAdmission(Admission admission) {

        if (admission == null || admission.getId() <= 0) {
            System.out.println("Invalid admission.");
            return false;
        }

        return true; // admission is a live in-memory reference; caller already mutated it
    }

    public boolean dischargePatient(int admissionId) {

        Admission admission = getAdmissionById(admissionId);

        if (admission == null) {
            System.out.println("Admission not found.");
            return false;
        }

        admission.setStatus("DISCHARGED");
        admission.setDischargeDate(LocalDate.now());

        if (admission.getBed() != null) {
            admission.getBed().setStatus("AVAILABLE");
        }

        return true;
    }

    public List<Admission> getActiveAdmissions() {
        return admissionDAO.findActiveAdmissions();
    }

    public List<Admission> getAdmissionsByPatient(int patientId) {
        return admissionDAO.findAdmissionsByPatient(patientId);
    }
}
