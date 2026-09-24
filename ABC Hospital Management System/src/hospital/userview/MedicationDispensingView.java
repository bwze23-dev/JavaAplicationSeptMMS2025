package hospital.userview;

import hospital.models.MedicationDispensing;

import java.util.List;

public class MedicationDispensingView {

    public void displayRecords(List<MedicationDispensing> records) {

        if (records == null || records.isEmpty()) {
            System.out.println();
            System.out.println("No dispensing records found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-25s %-8s %-16s%n",
                "ID", "PATIENT", "MEDICATION", "QTY", "DATE");
        System.out.println("========================================================================================");

        for (MedicationDispensing d : records) {
            String patientName = d.getPatient() != null
                    ? d.getPatient().getFirstName() + " " + d.getPatient().getLastName() : "N/A";
            String medicationName = d.getPrescriptionItem() != null && d.getPrescriptionItem().getMedication() != null
                    ? d.getPrescriptionItem().getMedication().getName() : "N/A";

            System.out.printf("%-6d %-22s %-25s %-8d %-16s%n",
                    d.getId(), patientName, medicationName, d.getQuantity(),
                    d.getDispensingDate() != null ? d.getDispensingDate().toString() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayMedicationDispensed() {
        System.out.println();
        System.out.println("Medication dispensed successfully.");
    }
}
