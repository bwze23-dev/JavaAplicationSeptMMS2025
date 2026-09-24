package hospital.dao;

import hospital.models.MedicalRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicalRecordDAO {
    private static final List<MedicalRecord> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(MedicalRecord record) {
        if (record == null) return false;
        if (record.getId() <= 0) record.setId(nextId++);
        else nextId = Math.max(nextId, record.getId() + 1);
        storage.add(record);
        return true;
    }
    public List<MedicalRecord> findAll() { return new ArrayList<>(storage); }
    public Optional<MedicalRecord> findById(int id) {
        return storage.stream().filter(r -> r.getId() == id).findFirst();
    }
    public List<MedicalRecord> findByPatient(int patientId) {
        return storage.stream().filter(r -> r.getPatient() != null &&
                r.getPatient().getPatientID() == patientId).collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(r -> r.getId() == id); }
}
