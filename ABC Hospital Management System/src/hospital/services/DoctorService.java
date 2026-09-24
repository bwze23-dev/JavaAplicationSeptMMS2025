package hospital.services;

import hospital.dao.DoctorDAO;
import hospital.models.Doctor;

import java.util.List;

public class DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorService() {
        doctorDAO = new DoctorDAO();
    }

    // =========================================================
    // REGISTER DOCTOR
    // =========================================================

    public boolean registerDoctor(Doctor doctor) {

        if (doctor == null) {
            System.out.println("Doctor cannot be null.");
            return false;
        }

        if (doctor.getFirstName() == null || doctor.getFirstName().trim().isEmpty()) {
            System.out.println("First name is required.");
            return false;
        }

        if (doctor.getLastName() == null || doctor.getLastName().trim().isEmpty()) {
            System.out.println("Last name is required.");
            return false;
        }

        return doctorDAO.addDoctor(doctor);
    }

    // =========================================================
    // GET ALL DOCTORS
    // =========================================================

    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAllDoctors();
    }

    // =========================================================
    // GET DOCTOR BY ID
    // =========================================================

    public Doctor getDoctorById(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid doctor/staff ID.");
            return null;
        }

        return doctorDAO.findDoctorById(staffId);
    }

    // =========================================================
    // UPDATE DOCTOR
    // =========================================================

    public boolean updateDoctor(Doctor doctor) {

        if (doctor == null) {
            System.out.println("Doctor cannot be null.");
            return false;
        }

        if (doctor.getStaffID() <= 0) {
            System.out.println("Invalid doctor/staff ID.");
            return false;
        }

        return doctorDAO.update(doctor);
    }

    // =========================================================
    // DELETE DOCTOR
    // =========================================================

    public boolean deleteDoctor(int staffId) {

        if (staffId <= 0) {
            System.out.println("Invalid doctor/staff ID.");
            return false;
        }

        return doctorDAO.delete(staffId);
    }
}
