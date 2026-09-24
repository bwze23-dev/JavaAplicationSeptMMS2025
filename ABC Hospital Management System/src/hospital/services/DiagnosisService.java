package hospital.services;

import hospital.dao.DiagnosisDAO;
import hospital.models.Diagnosis;

import java.time.LocalDate;
import java.util.List;

public class DiagnosisService {

    private final DiagnosisDAO diagnosisDAO;

    public DiagnosisService() {
        diagnosisDAO = new DiagnosisDAO();
    }

    public boolean addDiagnosis(Diagnosis diagnosis) {

        if (diagnosis == null) {
            System.out.println("Diagnosis cannot be null.");
            return false;
        }

        if (diagnosis.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (diagnosis.getDiagnosisName() == null || diagnosis.getDiagnosisName().trim().isEmpty()) {
            System.out.println("Diagnosis name is required.");
            return false;
        }

        if (diagnosis.getDiagnosisDate() == null) {
            diagnosis.setDiagnosisDate(LocalDate.now());
        }

        if (diagnosis.getStatus() == null || diagnosis.getStatus().trim().isEmpty()) {
            diagnosis.setStatus("ACTIVE");
        }

        diagnosisDAO.addDiagnosis(diagnosis);
        return true;
    }

    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisDAO.findAllDiagnoses();
    }

    public List<Diagnosis> getDiagnosesByPatient(int patientId) {
        return diagnosisDAO.findDiagnosesByPatient(patientId);
    }
}
