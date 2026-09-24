package hospital.dao;

import hospital.models.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentDAO {
    private static final List<Payment> storage = new ArrayList<>();
    private static int nextId = 1;

    public boolean add(Payment payment) {
        if (payment == null) return false;
        if (payment.getId() <= 0) payment.setId(nextId++);
        else nextId = Math.max(nextId, payment.getId() + 1);
        storage.add(payment);
        return true;
    }
    public List<Payment> findAll() { return new ArrayList<>(storage); }
    public Optional<Payment> findById(int id) {
        return storage.stream().filter(p -> p.getId() == id).findFirst();
    }
    public List<Payment> findByInvoice(int invoiceId) {
        return storage.stream().filter(p -> p.getInvoice() != null &&
                p.getInvoice().getId() == invoiceId).collect(Collectors.toList());
    }
    public boolean deleteById(int id) { return storage.removeIf(p -> p.getId() == id); }
}
