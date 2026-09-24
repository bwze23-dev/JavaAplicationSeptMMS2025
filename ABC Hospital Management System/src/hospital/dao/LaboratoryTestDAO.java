package hospital.dao;

import hospital.models.LaboratoryTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LaboratoryTestDAO {
    private static final List<LaboratoryTest> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(LaboratoryTest test) {
        if (test == null) return false;
        if (test.getId() <= 0) test.setId(nextId++);
        else nextId = Math.max(nextId, test.getId() + 1);
        storage.add(test);
        return true;
    }
    public List<LaboratoryTest> findAll() { return new ArrayList<>(storage); }
    public Optional<LaboratoryTest> findById(int id) {
        return storage.stream().filter(t -> t.getId() == id).findFirst();
    }
    public List<LaboratoryTest> findByPatient(int patientId) {
        return storage.stream().filter(t -> t.getPatient() != null &&
                t.getPatient().getPatientID() == patientId).collect(Collectors.toList());
    }
    public List<LaboratoryTest> findByStatus(String status) {
        return storage.stream().filter(t -> status != null && status.equalsIgnoreCase(t.getStatus()))
                .collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(t -> t.getId() == id); }
}
