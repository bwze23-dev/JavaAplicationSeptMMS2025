package hospital.services;

import hospital.dao.TreatmentDAO;
import hospital.models.Treatment;

import java.time.LocalDate;
import java.util.List;

public class TreatmentService {

    private final TreatmentDAO treatmentDAO;

    public TreatmentService() {
        treatmentDAO = new TreatmentDAO();
    }

    public boolean addTreatment(Treatment treatment) {

        if (treatment == null) {
            System.out.println("Treatment cannot be null.");
            return false;
        }

        if (treatment.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (treatment.getTreatmentName() == null || treatment.getTreatmentName().trim().isEmpty()) {
            System.out.println("Treatment name is required.");
            return false;
        }

        if (treatment.getTreatmentDate() == null) {
            treatment.setTreatmentDate(LocalDate.now());
        }

        if (treatment.getStatus() == null || treatment.getStatus().trim().isEmpty()) {
            treatment.setStatus("ONGOING");
        }

        treatmentDAO.add(treatment);
        return true;
    }

    public List<Treatment> getAllTreatments() {
        return treatmentDAO.findAll();
    }

    public List<Treatment> getTreatmentsByPatient(int patientId) {
        return treatmentDAO.findByPatient(patientId);
    }
}
