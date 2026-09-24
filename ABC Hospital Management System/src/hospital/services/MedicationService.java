package hospital.services;

import hospital.dao.MedicationDAO;
import hospital.models.Medication;

import java.util.List;

public class MedicationService {

    private final MedicationDAO medicationDAO;

    public MedicationService() {
        medicationDAO = new MedicationDAO();
    }

    public boolean addMedication(Medication medication) {

        if (medication == null) {
            System.out.println("Medication cannot be null.");
            return false;
        }

        if (medication.getName() == null || medication.getName().trim().isEmpty()) {
            System.out.println("Medication name is required.");
            return false;
        }

        medicationDAO.addMedication(medication);
        return true;
    }

    public List<Medication> getAllMedications() {
        return medicationDAO.findAllMedications();
    }

    public Medication getMedicationById(int medicationId) {

        if (medicationId <= 0) {
            System.out.println("Invalid medication ID.");
            return null;
        }

        return medicationDAO.findMedicationById(medicationId);
    }

    public boolean updateStock(int medicationId, int newQuantity) {

        Medication medication = getMedicationById(medicationId);

        if (medication == null) {
            System.out.println("Medication not found.");
            return false;
        }

        medication.setQuantityInStock(newQuantity);
        return true;
    }

    public List<Medication> getAvailableMedications() {
        return medicationDAO.findAvailableMedications();
    }

    public List<Medication> getLowStockMedications() {
        return medicationDAO.findLowStockMedications();
    }
}
