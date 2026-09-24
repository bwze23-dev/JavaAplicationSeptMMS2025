package hospital.userview;

import hospital.models.LaboratoryTest;

import java.util.List;

public class LaboratoryTestView {

    public void displayTests(List<LaboratoryTest> tests) {

        if (tests == null || tests.isEmpty()) {
            System.out.println();
            System.out.println("No laboratory tests found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-25s %-12s %-15s%n",
                "ID", "PATIENT", "TEST", "STATUS", "RESULT");
        System.out.println("========================================================================================");

        for (LaboratoryTest t : tests) {
            String patientName = t.getPatient() != null
                    ? t.getPatient().getFirstName() + " " + t.getPatient().getLastName() : "N/A";

            System.out.printf("%-6d %-22s %-25s %-12s %-15s%n",
                    t.getId(), patientName,
                    t.getTestName() != null ? t.getTestName() : "",
                    t.getStatus() != null ? t.getStatus() : "",
                    t.getResult() != null ? t.getResult() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayTest(LaboratoryTest t) {

        if (t == null) {
            System.out.println("Laboratory test not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("          LABORATORY TEST DETAILS");
        System.out.println("==============================================");
        System.out.println("Test ID        : " + t.getId());
        System.out.println("Patient        : " + (t.getPatient() != null ? t.getPatient().getFirstName() + " " + t.getPatient().getLastName() : "N/A"));
        System.out.println("Technician     : " + (t.getTechnician() != null ? t.getTechnician().getFirstName() + " " + t.getTechnician().getLastName() : "N/A"));
        System.out.println("Test Name      : " + t.getTestName());
        System.out.println("Test Date      : " + t.getTestDate());
        System.out.println("Status         : " + t.getStatus());
        System.out.println("Result         : " + t.getResult());
        System.out.println("Reference Range: " + t.getReferenceRange());
        System.out.println("==============================================");
    }

    public void displayTestCreated() {
        System.out.println();
        System.out.println("Laboratory test created successfully.");
    }

    public void displayResultRecorded() {
        System.out.println();
        System.out.println("Test result recorded successfully.");
    }
}
