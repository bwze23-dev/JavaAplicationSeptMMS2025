package hospital.userview;

import hospital.models.Doctor;

import java.util.List;

public class DoctorView {

    public void displayDoctors(List<Doctor> doctors) {

        if (doctors == null || doctors.isEmpty()) {
            System.out.println();
            System.out.println("No doctors found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-25s %-20s %-20s %-14s%n",
                "ID", "NAME", "DEPARTMENT", "SPECIALIZATION", "LICENSE");
        System.out.println("========================================================================================");

        for (Doctor doctor : doctors) {
            System.out.printf("%-6d %-25s %-20s %-20s %-14s%n",
                    doctor.getStaffID(),
                    "Dr. " + doctor.getFirstName() + " " + doctor.getLastName(),
                    doctor.getDepartment() != null ? doctor.getDepartment().getName() : "",
                    doctor.getSpecialization() != null ? doctor.getSpecialization() : "",
                    doctor.getLicenseNumber() != null ? doctor.getLicenseNumber() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayDoctor(Doctor doctor) {

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("              DOCTOR DETAILS");
        System.out.println("==============================================");
        System.out.println("Staff ID       : " + doctor.getStaffID());
        System.out.println("Name           : Dr. " + doctor.getFirstName() + " " + doctor.getLastName());
        System.out.println("Gender         : " + doctor.getGender());
        System.out.println("Phone          : " + doctor.getPhone());
        System.out.println("Email          : " + doctor.getEmail());
        System.out.println("Department     : " + (doctor.getDepartment() != null ? doctor.getDepartment().getName() : "N/A"));
        System.out.println("Specialization : " + doctor.getSpecialization());
        System.out.println("License Number : " + doctor.getLicenseNumber());
        System.out.println("Employment Date: " + doctor.getEmploymentDate());
        System.out.println("Salary         : " + doctor.getSalary());
        System.out.println("==============================================");
    }

    public void displayDoctorRegistered() {
        System.out.println();
        System.out.println("Doctor registered successfully.");
    }

    public void displayDoctorUpdated() {
        System.out.println();
        System.out.println("Doctor updated successfully.");
    }

    public void displayDoctorDeleted() {
        System.out.println();
        System.out.println("Doctor deleted successfully.");
    }
}
