package hospital.userview;

import hospital.models.Invoice;
import hospital.models.InvoiceItem;

import java.util.List;

public class InvoiceView {

    public void displayInvoices(List<Invoice> invoices) {

        if (invoices == null || invoices.isEmpty()) {
            System.out.println();
            System.out.println("No invoices found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-22s %-12s %-12s %-10s%n",
                "ID", "PATIENT", "DATE", "TOTAL", "STATUS");
        System.out.println("========================================================================================");

        for (Invoice inv : invoices) {
            String patientName = inv.getPatient() != null
                    ? inv.getPatient().getFirstName() + " " + inv.getPatient().getLastName() : "N/A";

            System.out.printf("%-6d %-22s %-12s %-12.2f %-10s%n",
                    inv.getId(), patientName,
                    inv.getInvoiceDate() != null ? inv.getInvoiceDate().toString() : "",
                    inv.getTotalAmount(),
                    inv.getStatus() != null ? inv.getStatus() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayInvoice(Invoice inv) {

        if (inv == null) {
            System.out.println("Invoice not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("            INVOICE #" + inv.getId());
        System.out.println("==============================================");
        System.out.println("Patient: " + (inv.getPatient() != null ? inv.getPatient().getFirstName() + " " + inv.getPatient().getLastName() : "N/A"));
        System.out.println("Date   : " + inv.getInvoiceDate());
        System.out.println("Status : " + inv.getStatus());
        System.out.println("----------------------------------------------");

        List<InvoiceItem> items = inv.getItems();
        if (items == null || items.isEmpty()) {
            System.out.println("No line items on this invoice.");
        } else {
            System.out.printf("%-30s %-10s%n", "DESCRIPTION", "AMOUNT");
            for (InvoiceItem item : items) {
                System.out.printf("%-30s %-10.2f%n", item.getDescription(), item.getAmount());
            }
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL: %.2f%n", inv.getTotalAmount());
        System.out.println("==============================================");
    }

    public void displayInvoiceCreated() {
        System.out.println();
        System.out.println("Invoice created successfully.");
    }

    public void displayItemAdded() {
        System.out.println();
        System.out.println("Invoice item added successfully.");
    }
}
