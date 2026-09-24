package hospital.userview;

import hospital.models.MedicalRecord;

import java.util.List;

public class MedicalRecordView {

    public void displayRecords(List<MedicalRecord> records) {

        if (records == null || records.isEmpty()) {
            System.out.println();
            System.out.println("No medical records found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.printf("%-6s %-25s %-12s%n", "ID", "PATIENT", "CREATED");
        System.out.println("========================================================");

        for (MedicalRecord r : records) {
            String patientName = r.getPatient() != null
                    ? r.getPatient().getFirstName() + " " + r.getPatient().getLastName() : "N/A";

            System.out.printf("%-6d %-25s %-12s%n",
                    r.getId(), patientName,
                    r.getCreatedDate() != null ? r.getCreatedDate().toString() : "");
        }

        System.out.println("========================================================");
    }

    public void displayRecordCreated() {
        System.out.println();
        System.out.println("Medical record created successfully.");
    }
}
