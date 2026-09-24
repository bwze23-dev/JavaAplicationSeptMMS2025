package hospital.userview;

import hospital.models.Pharmacist;

import java.util.List;

public class PharmacistView {

    public void displayPharmacists(List<Pharmacist> pharmacists) {

        if (pharmacists == null || pharmacists.isEmpty()) {
            System.out.println();
            System.out.println("No pharmacists found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-20s %-14s %-14s%n",
                "ID", "NAME", "QUALIFICATION", "LICENSE", "PHONE");
        System.out.println("========================================================================================");

        for (Pharmacist p : pharmacists) {
            System.out.printf("%-6d %-25s %-20s %-14s %-14s%n",
                    p.getStaffID(), p.getFirstName() + " " + p.getLastName(),
                    p.getQualification() != null ? p.getQualification() : "",
                    p.getLicenseNumber() != null ? p.getLicenseNumber() : "",
                    p.getPhone() != null ? p.getPhone() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayPharmacist(Pharmacist p) {

        if (p == null) {
            System.out.println("Pharmacist not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("            PHARMACIST DETAILS");
        System.out.println("==============================================");
        System.out.println("Staff ID      : " + p.getStaffID());
        System.out.println("Name          : " + p.getFirstName() + " " + p.getLastName());
        System.out.println("Phone         : " + p.getPhone());
        System.out.println("Email         : " + p.getEmail());
        System.out.println("Department    : " + (p.getDepartment() != null ? p.getDepartment().getName() : "N/A"));
        System.out.println("Qualification : " + p.getQualification());
        System.out.println("License Number: " + p.getLicenseNumber());
        System.out.println("==============================================");
    }

    public void displayPharmacistRegistered() {
        System.out.println();
        System.out.println("Pharmacist registered successfully.");
    }

    public void displayPharmacistDeleted() {
        System.out.println();
        System.out.println("Pharmacist deleted successfully.");
    }
}
