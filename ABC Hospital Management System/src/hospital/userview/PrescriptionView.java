package hospital.userview;

import hospital.models.Prescription;
import hospital.models.PrescriptionItem;

import java.util.List;

public class PrescriptionView {

    public void displayPrescriptions(List<Prescription> prescriptions) {

        if (prescriptions == null || prescriptions.isEmpty()) {
            System.out.println();
            System.out.println("No prescriptions found.");
            return;
        }

        for (Prescription p : prescriptions) {
            displayPrescription(p);
        }
    }

    public void displayPrescription(Prescription p) {

        if (p == null) {
            System.out.println("Prescription not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("          PRESCRIPTION #" + p.getId());
        System.out.println("==============================================");
        System.out.println("Patient : " + (p.getPatient() != null ? p.getPatient().getFirstName() + " " + p.getPatient().getLastName() : "N/A"));
        System.out.println("Doctor  : " + (p.getDoctor() != null ? "Dr. " + p.getDoctor().getFirstName() + " " + p.getDoctor().getLastName() : "N/A"));
        System.out.println("Date    : " + p.getPrescriptionDate());
        System.out.println("----------------------------------------------");

        List<PrescriptionItem> items = p.getItems();
        if (items == null || items.isEmpty()) {
            System.out.println("No items on this prescription.");
        } else {
            System.out.printf("%-20s %-10s %-10s %-8s%n", "MEDICATION", "DOSAGE", "FREQUENCY", "DURATION");
            for (PrescriptionItem item : items) {
                System.out.printf("%-20s %-10s %-10s %-8s%n",
                        item.getMedication() != null ? item.getMedication().getName() : "",
                        item.getDosage() != null ? item.getDosage() : "",
                        item.getFrequency() != null ? item.getFrequency() : "",
                        item.getDuration() + " " + (item.getDurationUnit() != null ? item.getDurationUnit() : ""));
            }
        }

        System.out.println("==============================================");
    }

    public void displayPrescriptionCreated() {
        System.out.println();
        System.out.println("Prescription created successfully.");
    }

    public void displayItemAdded() {
        System.out.println();
        System.out.println("Prescription item added successfully.");
    }
}
