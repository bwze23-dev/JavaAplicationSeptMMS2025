package hospital.dao;

import hospital.models.LaboratoryTechnician;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LaboratoryTechnicianDAO {
    private static final List<LaboratoryTechnician> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(LaboratoryTechnician technician) {
        if (technician == null) return false;
        if (technician.getStaffID() <= 0) technician.setStaffID(nextId++);
        else nextId = Math.max(nextId, technician.getStaffID() + 1);
        storage.add(technician);
        return true;
    }
    public List<LaboratoryTechnician> findAll() { return new ArrayList<>(storage); }
    public Optional<LaboratoryTechnician> findById(int staffId) {
        return storage.stream().filter(t -> t.getStaffID() == staffId).findFirst();
    }
    public boolean deleteById(int staffId) { return storage.removeIf(t -> t.getStaffID() == staffId); }
}
