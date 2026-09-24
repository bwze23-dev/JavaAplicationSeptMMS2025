package hospital.dao;

import hospital.models.Treatment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TreatmentDAO {
    private static final List<Treatment> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(Treatment treatment) {
        if (treatment == null) return false;
        if (treatment.getId() <= 0) treatment.setId(nextId++);
        else nextId = Math.max(nextId, treatment.getId() + 1);
        storage.add(treatment);
        return true;
    }
    public List<Treatment> findAll() { return new ArrayList<>(storage); }
    public Optional<Treatment> findById(int id) { return storage.stream().filter(t -> t.getId() == id).findFirst(); }
    public List<Treatment> findByPatient(int patientId) {
        return storage.stream().filter(t -> t.getPatient() != null &&
                t.getPatient().getPatientID() == patientId).collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(t -> t.getId() == id); }
}
