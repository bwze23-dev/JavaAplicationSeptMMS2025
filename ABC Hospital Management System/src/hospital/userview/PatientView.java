package hospital.userview;

import hospital.models.Patient;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PatientView {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void displayPatients(List<Patient> patients) {

        if (patients == null || patients.isEmpty()) {
            System.out.println();
            System.out.println("No patients found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-4s %-12s %-8s %-14s %-10s%n",
                "ID", "NAME", "SEX", "PHONE", "BLOOD", "EMERGENCY", "EMG PHONE");
        System.out.println("========================================================================================");

        for (Patient patient : patients) {
            System.out.printf("%-6d %-25s %-4c %-12s %-8s %-14s %-10s%n",
                    patient.getPatientID(),
                    patient.getFirstName() + " " + patient.getLastName(),
                    patient.getGender(),
                    patient.getPhone() != null ? patient.getPhone() : "",
                    patient.getBloodGroup() != null ? patient.getBloodGroup() : "",
                    patient.getEmergencyContact() != null ? patient.getEmergencyContact() : "",
                    patient.getEmergencyPhone() != null ? patient.getEmergencyPhone() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayPatient(Patient patient) {

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("             PATIENT DETAILS");
        System.out.println("==============================================");
        System.out.println("Patient ID       : " + patient.getPatientID());
        System.out.println("Name             : " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Gender           : " + patient.getGender());
        System.out.println("Date of Birth    : " + (patient.getDateOfBirth() != null ? patient.getDateOfBirth().format(dateFormatter) : "N/A"));
        System.out.println("Phone            : " + patient.getPhone());
        System.out.println("Email            : " + patient.getEmail());
        System.out.println("Address          : " + patient.getStreet() + ", " + patient.getCity() + ", " + patient.getCountry());
        System.out.println("Blood Group      : " + patient.getBloodGroup());
        System.out.println("Genotype         : " + patient.getGenotype());
        System.out.println("Allergies        : " + patient.getAllergies());
        System.out.println("Emergency Contact: " + patient.getEmergencyContact());
        System.out.println("Emergency Phone  : " + patient.getEmergencyPhone());
        System.out.println("==============================================");
    }

    public void displayPatientRegistered() {
        System.out.println();
        System.out.println("Patient registered successfully.");
    }

    public void displayPatientUpdated() {
        System.out.println();
        System.out.println("Patient updated successfully.");
    }

    public void displayPatientDeleted() {
        System.out.println();
        System.out.println("Patient deleted successfully.");
    }
}
