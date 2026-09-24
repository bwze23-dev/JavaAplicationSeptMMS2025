package hospital.dao;

import hospital.models.MedicationDispensing;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicationDispensingDAO {
    private static final List<MedicationDispensing> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(MedicationDispensing record) {
        if (record == null) return false;
        if (record.getId() <= 0) record.setId(nextId++);
        else nextId = Math.max(nextId, record.getId() + 1);
        storage.add(record);
        return true;
    }
    public List<MedicationDispensing> findAll() { return new ArrayList<>(storage); }
    public Optional<MedicationDispensing> findById(int id) {
        return storage.stream().filter(r -> r.getId() == id).findFirst();
    }
    public boolean deleteById(int id) { return storage.removeIf(r -> r.getId() == id); }
}
