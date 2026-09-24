package hospital.services;

import hospital.dao.PatientDAO;
import hospital.models.Patient;

import java.util.List;

public class PatientService {

    private final PatientDAO patientDAO;

    public PatientService() {
        patientDAO = new PatientDAO();
    }

    // =========================================================
    // REGISTER PATIENT
    // =========================================================

    public boolean registerPatient(Patient patient) {

        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return false;
        }

        if (patient.getFirstName() == null || patient.getFirstName().trim().isEmpty()) {
            System.out.println("First name is required.");
            return false;
        }

        if (patient.getLastName() == null || patient.getLastName().trim().isEmpty()) {
            System.out.println("Last name is required.");
            return false;
        }

        return patientDAO.addPatient(patient);
    }

    // =========================================================
    // GET ALL PATIENTS
    // =========================================================

    public List<Patient> getAllPatients() {
        return patientDAO.findAllPatient();
    }

    // =========================================================
    // GET PATIENT BY ID
    // =========================================================

    public Patient getPatientById(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return null;
        }

        return patientDAO.findPatientById(patientId);
    }

    // =========================================================
    // UPDATE PATIENT
    // =========================================================

    public boolean updatePatient(Patient patient) {

        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return false;
        }

        if (patient.getPatientID() <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        return patientDAO.update(patient);
    }

    // =========================================================
    // DELETE PATIENT
    // =========================================================

    public boolean deletePatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        return patientDAO.delete(patientId);
    }
}
