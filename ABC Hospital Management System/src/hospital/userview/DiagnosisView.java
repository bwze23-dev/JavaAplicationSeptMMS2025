package hospital.userview;

import hospital.models.Diagnosis;

import java.util.List;

public class DiagnosisView {

    public void displayDiagnoses(List<Diagnosis> diagnoses) {

        if (diagnoses == null || diagnoses.isEmpty()) {
            System.out.println();
            System.out.println("No diagnoses found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-20s %-25s %-12s %-10s%n",
                "ID", "PATIENT", "DOCTOR", "DIAGNOSIS", "DATE", "STATUS");
        System.out.println("========================================================================================");

        for (Diagnosis d : diagnoses) {
            String patientName = d.getPatient() != null
                    ? d.getPatient().getFirstName() + " " + d.getPatient().getLastName() : "N/A";
            String doctorName = d.getDoctor() != null
                    ? "Dr. " + d.getDoctor().getFirstName() + " " + d.getDoctor().getLastName() : "N/A";

            System.out.printf("%-6d %-22s %-20s %-25s %-12s %-10s%n",
                    d.getId(), patientName, doctorName,
                    d.getDiagnosisName() != null ? d.getDiagnosisName() : "",
                    d.getDiagnosisDate() != null ? d.getDiagnosisDate().toString() : "",
                    d.getStatus() != null ? d.getStatus() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayDiagnosisAdded() {
        System.out.println();
        System.out.println("Diagnosis recorded successfully.");
    }
}
