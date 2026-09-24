package hospital.userview;

import hospital.models.LaboratoryTechnician;

import java.util.List;

public class LaboratoryTechnicianView {

    public void displayTechnicians(List<LaboratoryTechnician> technicians) {

        if (technicians == null || technicians.isEmpty()) {
            System.out.println();
            System.out.println("No laboratory technicians found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-25s %-14s%n",
                "ID", "NAME", "QUALIFICATION", "LICENSE");
        System.out.println("========================================================================================");

        for (LaboratoryTechnician t : technicians) {
            System.out.printf("%-6d %-25s %-25s %-14s%n",
                    t.getStaffID(), t.getFirstName() + " " + t.getLastName(),
                    t.getQualification() != null ? t.getQualification() : "",
                    t.getLicenseNumber() != null ? t.getLicenseNumber() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayTechnician(LaboratoryTechnician t) {

        if (t == null) {
            System.out.println("Laboratory technician not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("        LABORATORY TECHNICIAN DETAILS");
        System.out.println("==============================================");
        System.out.println("Staff ID      : " + t.getStaffID());
        System.out.println("Name          : " + t.getFirstName() + " " + t.getLastName());
        System.out.println("Phone         : " + t.getPhone());
        System.out.println("Email         : " + t.getEmail());
        System.out.println("Department    : " + (t.getDepartment() != null ? t.getDepartment().getName() : "N/A"));
        System.out.println("Qualification : " + t.getQualification());
        System.out.println("License Number: " + t.getLicenseNumber());
        System.out.println("==============================================");
    }

    public void displayTechnicianRegistered() {
        System.out.println();
        System.out.println("Laboratory technician registered successfully.");
    }

    public void displayTechnicianDeleted() {
        System.out.println();
        System.out.println("Laboratory technician deleted successfully.");
    }
}
