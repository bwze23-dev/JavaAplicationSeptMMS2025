package hospital.services;

import hospital.dao.MedicationDispensingDAO;
import hospital.models.MedicationDispensing;
import hospital.models.PrescriptionItem;

import java.time.LocalDateTime;
import java.util.List;

public class MedicationDispensingService {

    private final MedicationDispensingDAO medicationDispensingDAO;

    public MedicationDispensingService() {
        medicationDispensingDAO = new MedicationDispensingDAO();
    }

    public boolean dispenseMedication(MedicationDispensing record) {

        if (record == null) {
            System.out.println("Dispensing record cannot be null.");
            return false;
        }

        PrescriptionItem item = record.getPrescriptionItem();

        if (item == null || item.getMedication() == null) {
            System.out.println("Prescription item and medication are required.");
            return false;
        }

        if (item.getMedication().getQuantityInStock() < record.getQuantity()) {
            System.out.println("Insufficient stock to dispense this medication.");
            return false;
        }

        item.getMedication().setQuantityInStock(
                item.getMedication().getQuantityInStock() - record.getQuantity()
        );

        record.setDispensingDate(LocalDateTime.now());
        record.setStatus("DISPENSED");
        medicationDispensingDAO.add(record);
        return true;
    }

    public List<MedicationDispensing> getAllDispensingRecords() {
        return medicationDispensingDAO.findAll();
    }
}
