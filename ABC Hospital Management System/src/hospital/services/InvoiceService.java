package hospital.services;

import hospital.dao.InvoiceDAO;
import hospital.models.Invoice;
import hospital.models.InvoiceItem;

import java.time.LocalDate;
import java.util.List;

public class InvoiceService {

    private final InvoiceDAO invoiceDAO;

    public InvoiceService() {
        invoiceDAO = new InvoiceDAO();
    }

    public boolean createInvoice(Invoice invoice) {

        if (invoice == null) {
            System.out.println("Invoice cannot be null.");
            return false;
        }

        if (invoice.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (invoice.getInvoiceDate() == null) {
            invoice.setInvoiceDate(LocalDate.now());
        }

        if (invoice.getStatus() == null || invoice.getStatus().trim().isEmpty()) {
            invoice.setStatus("UNPAID");
        }

        invoiceDAO.add(invoice);
        return true;
    }

    public boolean addInvoiceItem(Invoice invoice, InvoiceItem item) {

        if (invoice == null || item == null) {
            System.out.println("Invoice and item are required.");
            return false;
        }

        invoice.addItem(item);
        return true;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceDAO.findAll();
    }

    public Invoice getInvoiceById(int invoiceId) {

        if (invoiceId <= 0) {
            System.out.println("Invalid invoice ID.");
            return null;
        }

        return invoiceDAO.findById(invoiceId).orElse(null);
    }

    public List<Invoice> getInvoicesByPatient(int patientId) {
        return invoiceDAO.findByPatient(patientId);
    }

    public List<Invoice> getOutstandingInvoices() {
        return invoiceDAO.findWhere(i -> !"PAID".equalsIgnoreCase(i.getStatus()));
    }
}
