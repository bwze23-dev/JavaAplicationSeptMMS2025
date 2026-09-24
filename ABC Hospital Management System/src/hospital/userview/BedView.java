package hospital.userview;

import hospital.models.Bed;

import java.util.List;

public class BedView {

    public void displayBeds(List<Bed> beds) {

        if (beds == null || beds.isEmpty()) {
            System.out.println();
            System.out.println("No beds found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.printf("%-6s %-10s %-10s %-15s%n", "ID", "BED NO", "ROOM", "STATUS");
        System.out.println("========================================================");

        for (Bed b : beds) {
            System.out.printf("%-6d %-10s %-10s %-15s%n",
                    b.getId(), b.getBedNumber(),
                    b.getRoom() != null ? b.getRoom().getRoomNumber() : "",
                    b.getStatus() != null ? b.getStatus() : "");
        }

        System.out.println("========================================================");
    }

    public void displayBedAdded() {
        System.out.println();
        System.out.println("Bed added successfully.");
    }
}
