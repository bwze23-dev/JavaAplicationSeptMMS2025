
package hospital.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int id;
    private Patient patient;
    private LocalDate invoiceDate;
    private String status;

    private List<InvoiceItem> items = new ArrayList<>();

    public Invoice(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void addItem(InvoiceItem item){
        items.add(item);
    }

    public void removeItem(InvoiceItem item){
        items.remove(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (InvoiceItem item : items) {
            total += item.getAmount();
        }
        return total;
    }
}
