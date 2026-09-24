package hospital.userview;

import hospital.models.Medication;

import java.util.List;

public class MedicationView {

    public void displayMedications(List<Medication> medications) {

        if (medications == null || medications.isEmpty()) {
            System.out.println();
            System.out.println("No medications found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-12s %-10s %-8s%n",
                "ID", "NAME", "FORM", "PRICE", "STOCK");
        System.out.println("========================================================================================");

        for (Medication m : medications) {
            System.out.printf("%-6d %-25s %-12s %-10.2f %-8d%n",
                    m.getId(), m.getName(),
                    m.getDosageForm() != null ? m.getDosageForm() : "",
                    m.getPrice(), m.getQuantityInStock());
        }

        System.out.println("========================================================================================");
    }

    public void displayMedicationAdded() {
        System.out.println();
        System.out.println("Medication added successfully.");
    }

    public void displayStockUpdated() {
        System.out.println();
        System.out.println("Medication stock updated successfully.");
    }
}
