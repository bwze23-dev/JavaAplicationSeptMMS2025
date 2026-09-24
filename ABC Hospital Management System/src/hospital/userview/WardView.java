package hospital.userview;

import hospital.models.Ward;

import java.util.List;

public class WardView {

    public void displayWards(List<Ward> wards) {

        if (wards == null || wards.isEmpty()) {
            System.out.println();
            System.out.println("No wards found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.printf("%-6s %-25s %-15s %-10s %-8s%n", "ID", "NAME", "TYPE", "CAPACITY", "ROOMS");
        System.out.println("========================================================");

        for (Ward w : wards) {
            System.out.printf("%-6d %-25s %-15s %-10d %-8d%n",
                    w.getId(), w.getName(),
                    w.getWardType() != null ? w.getWardType() : "",
                    w.getCapacity(), w.getRooms().size());
        }

        System.out.println("========================================================");
    }

    public void displayWardAdded() {
        System.out.println();
        System.out.println("Ward added successfully.");
    }
}
