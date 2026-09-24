package hospital.userview;

import hospital.models.Treatment;

import java.util.List;

public class TreatmentView {

    public void displayTreatments(List<Treatment> treatments) {

        if (treatments == null || treatments.isEmpty()) {
            System.out.println();
            System.out.println("No treatments found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-20s %-25s %-12s %-10s%n",
                "ID", "PATIENT", "DOCTOR", "TREATMENT", "DATE", "STATUS");
        System.out.println("========================================================================================");

        for (Treatment t : treatments) {
            String patientName = t.getPatient() != null
                    ? t.getPatient().getFirstName() + " " + t.getPatient().getLastName() : "N/A";
            String doctorName = t.getDoctor() != null
                    ? "Dr. " + t.getDoctor().getFirstName() + " " + t.getDoctor().getLastName() : "N/A";

            System.out.printf("%-6d %-22s %-20s %-25s %-12s %-10s%n",
                    t.getId(), patientName, doctorName,
                    t.getTreatmentName() != null ? t.getTreatmentName() : "",
                    t.getTreatmentDate() != null ? t.getTreatmentDate().toString() : "",
                    t.getStatus() != null ? t.getStatus() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayTreatmentAdded() {
        System.out.println();
        System.out.println("Treatment recorded successfully.");
    }
}
