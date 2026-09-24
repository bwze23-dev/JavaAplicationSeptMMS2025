package hospital.dao;

import hospital.models.Prescription;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PrescriptionDAO {
    private static final List<Prescription> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(Prescription p) {
        if (p == null) return false;
        if (p.getId() <= 0) p.setId(nextId++);
        else nextId = Math.max(nextId, p.getId() + 1);
        storage.add(p);
        return true;
    }
    public List<Prescription> findAll() { return new ArrayList<>(storage); }
    public Optional<Prescription> findById(int id) {
        return storage.stream().filter(p -> p.getId() == id).findFirst();
    }
    public List<Prescription> findByPatient(int patientId) {
        return storage.stream().filter(p -> p.getPatient() != null &&
                p.getPatient().getPatientID() == patientId).collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(p -> p.getId() == id); }
}
