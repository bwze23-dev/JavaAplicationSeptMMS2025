package hospital.services;

import hospital.dao.LaboratoryTestDAO;
import hospital.models.LaboratoryTest;

import java.time.LocalDateTime;
import java.util.List;

public class LaboratoryTestService {

    private final LaboratoryTestDAO laboratoryTestDAO;

    public LaboratoryTestService() {
        laboratoryTestDAO = new LaboratoryTestDAO();
    }

    public boolean createTest(LaboratoryTest test) {

        if (test == null) {
            System.out.println("Laboratory test cannot be null.");
            return false;
        }

        if (test.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (test.getTestName() == null || test.getTestName().trim().isEmpty()) {
            System.out.println("Test name is required.");
            return false;
        }

        if (test.getTestDate() == null) {
            test.setTestDate(LocalDateTime.now());
        }

        if (test.getStatus() == null || test.getStatus().trim().isEmpty()) {
            test.setStatus("PENDING");
        }

        laboratoryTestDAO.add(test);
        return true;
    }

    public List<LaboratoryTest> getAllTests() {
        return laboratoryTestDAO.findAll();
    }

    public LaboratoryTest getTestById(int testId) {

        if (testId <= 0) {
            System.out.println("Invalid test ID.");
            return null;
        }

        return laboratoryTestDAO.findById(testId).orElse(null);
    }

    public List<LaboratoryTest> getTestsByPatient(int patientId) {
        return laboratoryTestDAO.findByPatient(patientId);
    }

    public List<LaboratoryTest> getPendingTests() {
        return laboratoryTestDAO.findByStatus("PENDING");
    }

    public List<LaboratoryTest> getCompletedTests() {
        return laboratoryTestDAO.findByStatus("COMPLETED");
    }

    public boolean recordResult(int testId, String result, String referenceRange) {

        LaboratoryTest test = getTestById(testId);

        if (test == null) {
            System.out.println("Test not found.");
            return false;
        }

        test.setResult(result);
        test.setReferenceRange(referenceRange);
        test.setStatus("COMPLETED");
        return true;
    }
}
