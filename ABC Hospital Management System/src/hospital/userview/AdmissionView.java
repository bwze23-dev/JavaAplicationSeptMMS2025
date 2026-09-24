package hospital.userview;

import hospital.models.Admission;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdmissionView {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public void displayAdmissions(List<Admission> admissions) {

        if (admissions == null || admissions.isEmpty()) {
            System.out.println();
            System.out.println("No admissions found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-8s %-20s %-12s %-16s%n",
                "ID", "PATIENT", "BED", "DOCTOR", "STATUS", "ADMITTED");
        System.out.println("========================================================================================");

        for (Admission a : admissions) {
            String patientName = a.getPatient() != null
                    ? a.getPatient().getFirstName() + " " + a.getPatient().getLastName() : "N/A";
            String bedNumber = a.getBed() != null ? a.getBed().getBedNumber() : "N/A";
            String doctorName = a.getAttendingDoctor() != null
                    ? "Dr. " + a.getAttendingDoctor().getFirstName() + " " + a.getAttendingDoctor().getLastName() : "N/A";
            String admittedDate = a.getAdmissionDate() != null ? a.getAdmissionDate().format(dateFormatter) : "";

            System.out.printf("%-6d %-22s %-8s %-20s %-12s %-16s%n",
                    a.getId(), patientName, bedNumber, doctorName,
                    a.getStatus() != null ? a.getStatus() : "", admittedDate);
        }

        System.out.println("========================================================================================");
    }

    public void displayAdmissionCreated() {
        System.out.println();
        System.out.println("Patient admitted successfully.");
    }

    public void displayPatientDischarged() {
        System.out.println();
        System.out.println("Patient discharged successfully.");
    }
}
