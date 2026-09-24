package hospital.userview;

import hospital.models.Nurse;

import java.util.List;

public class NurseView {

    public void displayNurses(List<Nurse> nurses) {

        if (nurses == null || nurses.isEmpty()) {
            System.out.println();
            System.out.println("No nurses found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-20s %-20s %-14s%n",
                "ID", "NAME", "DEPARTMENT", "QUALIFICATION", "LICENSE");
        System.out.println("========================================================================================");

        for (Nurse nurse : nurses) {
            System.out.printf("%-6d %-25s %-20s %-20s %-14s%n",
                    nurse.getStaffID(),
                    nurse.getFirstName() + " " + nurse.getLastName(),
                    nurse.getDepartment() != null ? nurse.getDepartment().getName() : "",
                    nurse.getQualification() != null ? nurse.getQualification() : "",
                    nurse.getNursingLicense() != null ? nurse.getNursingLicense() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayNurse(Nurse nurse) {

        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("              NURSE DETAILS");
        System.out.println("==============================================");
        System.out.println("Staff ID       : " + nurse.getStaffID());
        System.out.println("Name           : " + nurse.getFirstName() + " " + nurse.getLastName());
        System.out.println("Gender         : " + nurse.getGender());
        System.out.println("Phone          : " + nurse.getPhone());
        System.out.println("Email          : " + nurse.getEmail());
        System.out.println("Department     : " + (nurse.getDepartment() != null ? nurse.getDepartment().getName() : "N/A"));
        System.out.println("Qualification  : " + nurse.getQualification());
        System.out.println("Nursing License: " + nurse.getNursingLicense());
        System.out.println("Employment Date: " + nurse.getEmploymentDate());
        System.out.println("Salary         : " + nurse.getSalary());
        System.out.println("==============================================");
    }

    public void displayNurseRegistered() {
        System.out.println();
        System.out.println("Nurse registered successfully.");
    }

    public void displayNurseUpdated() {
        System.out.println();
        System.out.println("Nurse updated successfully.");
    }

    public void displayNurseDeleted() {
        System.out.println();
        System.out.println("Nurse deleted successfully.");
    }
}
