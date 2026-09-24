package hospital.services;

import hospital.dao.PaymentDAO;
import hospital.models.Invoice;
import hospital.models.Payment;

import java.time.LocalDate;
import java.util.List;

public class PaymentService {

    private final PaymentDAO paymentDAO;

    public PaymentService() {
        paymentDAO = new PaymentDAO();
    }

    public boolean recordPayment(Payment payment) {

        if (payment == null) {
            System.out.println("Payment cannot be null.");
            return false;
        }

        Invoice invoice = payment.getInvoice();

        if (invoice == null) {
            System.out.println("Invoice is required.");
            return false;
        }

        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(LocalDate.now());
        }

        paymentDAO.add(payment);

        double totalPaid = paymentDAO.findByInvoice(invoice.getId()).stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        if (totalPaid >= invoice.getTotalAmount()) {
            invoice.setStatus("PAID");
        } else if (totalPaid > 0) {
            invoice.setStatus("PARTIAL");
        }

        return true;
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.findAll();
    }

    public List<Payment> getPaymentsByInvoice(int invoiceId) {
        return paymentDAO.findByInvoice(invoiceId);
    }
}
