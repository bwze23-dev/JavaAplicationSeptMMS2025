package hospital.userview;

import hospital.models.Payment;

import java.util.List;

public class PaymentView {

    public void displayPayments(List<Payment> payments) {

        if (payments == null || payments.isEmpty()) {
            System.out.println();
            System.out.println("No payments found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-10s %-12s %-12s %-14s%n",
                "ID", "INVOICE", "AMOUNT", "DATE", "METHOD");
        System.out.println("========================================================================================");

        for (Payment p : payments) {
            System.out.printf("%-6d %-10d %-12.2f %-12s %-14s%n",
                    p.getId(),
                    p.getInvoice() != null ? p.getInvoice().getId() : 0,
                    p.getAmount(),
                    p.getPaymentDate() != null ? p.getPaymentDate().toString() : "",
                    p.getPaymentMethod() != null ? p.getPaymentMethod() : "");
        }

        System.out.println("========================================================================================");
    }

    public void displayPaymentRecorded() {
        System.out.println();
        System.out.println("Payment recorded successfully.");
    }
}
