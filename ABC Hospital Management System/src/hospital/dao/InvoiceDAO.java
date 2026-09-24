package hospital.dao;

import hospital.models.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InvoiceDAO {
    private static final List<Invoice> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(Invoice invoice) {
        if (invoice == null) return false;
        if (invoice.getId() <= 0) invoice.setId(nextId++);
        else nextId = Math.max(nextId, invoice.getId() + 1);
        storage.add(invoice);
        return true;
    }
    public List<Invoice> findAll() { return new ArrayList<>(storage); }
    public Optional<Invoice> findById(int id) { return storage.stream().filter(i -> i.getId() == id).findFirst(); }
    public List<Invoice> findWhere(Predicate<Invoice> condition) {
        return storage.stream().filter(condition).collect(Collectors.toList());
    }
    public List<Invoice> findByPatient(int patientId) {
        return storage.stream().filter(i -> i.getPatient() != null &&
                i.getPatient().getPatientID() == patientId).collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(i -> i.getId() == id); }
}
