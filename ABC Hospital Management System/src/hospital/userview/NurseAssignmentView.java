package hospital.userview;

import hospital.models.NurseAssignment;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class NurseAssignmentView {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public void displayAssignments(List<NurseAssignment> assignments) {

        if (assignments == null || assignments.isEmpty()) {
            System.out.println();
            System.out.println("No nurse assignments found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-22s %-10s %-12s %-16s%n",
                "ID", "NURSE", "PATIENT", "SHIFT", "STATUS", "ASSIGNED");
        System.out.println("========================================================================================");

        for (NurseAssignment a : assignments) {
            String nurseName = a.getNurse() != null
                    ? a.getNurse().getFirstName() + " " + a.getNurse().getLastName() : "N/A";
            String patientName = a.getPatient() != null
                    ? a.getPatient().getFirstName() + " " + a.getPatient().getLastName() : "N/A";
            String assignedDate = a.getAssignmentDate() != null ? a.getAssignmentDate().format(dateFormatter) : "";

            System.out.printf("%-6d %-22s %-22s %-10s %-12s %-16s%n",
                    a.getId(), nurseName, patientName,
                    a.getShift() != null ? a.getShift() : "",
                    a.getStatus() != null ? a.getStatus() : "", assignedDate);
        }

        System.out.println("========================================================================================");
    }

    public void displayNurseAssigned() {
        System.out.println();
        System.out.println("Nurse assigned successfully.");
    }
}
