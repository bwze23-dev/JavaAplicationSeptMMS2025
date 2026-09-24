package hospital.services;

import hospital.dao.PrescriptionDAO;
import hospital.models.Prescription;
import hospital.models.PrescriptionItem;

import java.time.LocalDate;
import java.util.List;

public class PrescriptionService {

    private final PrescriptionDAO prescriptionDAO;

    public PrescriptionService() {
        prescriptionDAO = new PrescriptionDAO();
    }

    public boolean createPrescription(Prescription prescription) {

        if (prescription == null) {
            System.out.println("Prescription cannot be null.");
            return false;
        }

        if (prescription.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (prescription.getPrescriptionDate() == null) {
            prescription.setPrescriptionDate(LocalDate.now());
        }

        prescriptionDAO.add(prescription);
        return true;
    }

    public boolean addItem(Prescription prescription, PrescriptionItem item) {

        if (prescription == null || item == null) {
            System.out.println("Prescription and item are required.");
            return false;
        }

        if (item.getMedication() == null) {
            System.out.println("Medication is required.");
            return false;
        }

        item.setPrescription(prescription);
        prescription.addItem(item);
        return true;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.findAll();
    }

    public List<Prescription> getPrescriptionsByPatient(int patientId) {
        return prescriptionDAO.findByPatient(patientId);
    }
}
