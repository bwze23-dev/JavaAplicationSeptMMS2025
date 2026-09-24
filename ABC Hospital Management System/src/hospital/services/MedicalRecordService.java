package hospital.services;

import hospital.dao.MedicalRecordDAO;
import hospital.models.MedicalRecord;

import java.time.LocalDate;
import java.util.List;

public class MedicalRecordService {

    private final MedicalRecordDAO medicalRecordDAO;

    public MedicalRecordService() {
        medicalRecordDAO = new MedicalRecordDAO();
    }

    public boolean createMedicalRecord(MedicalRecord record) {

        if (record == null) {
            System.out.println("Medical record cannot be null.");
            return false;
        }

        if (record.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (record.getCreatedDate() == null) {
            record.setCreatedDate(LocalDate.now());
        }

        medicalRecordDAO.add(record);
        return true;
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.findAll();
    }

    public List<MedicalRecord> getMedicalRecordsByPatient(int patientId) {
        return medicalRecordDAO.findByPatient(patientId);
    }
}
