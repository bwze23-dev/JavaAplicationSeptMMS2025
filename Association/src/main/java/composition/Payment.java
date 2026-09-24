

package composition;

import java.time.LocalDate;

public class Payment {
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String paymentType;
    
    public Payment(double amount, LocalDate paymentDate, String paymentMethod,
            String paymentType){
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentType = paymentType;
    }

    
    
    public void displayPaymentDetails(){
        System.out.println("========Payment Information==========");
        System.out.printf("Payment amount: %,.2f%n",amount);
        System.out.printf("Payment Date: %s%n",paymentDate);
        System.out.printf("Payment Method: %s%n", paymentMethod);
        System.out.printf("Payment Type: %s%n", paymentType);
    }    
}