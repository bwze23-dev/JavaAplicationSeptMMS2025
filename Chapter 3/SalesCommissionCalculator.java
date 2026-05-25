import java.util.Scanner;

public class SalesCommissionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double grossSales = 0.0;
        
        System.out.print("Enter item number sold (1-4, or -1 to finish): ");
        int item = input.nextInt();
        
        while (item != -1) {
            if (item == 1) {
                grossSales += 239.99;
            } else if (item == 2) {
                grossSales += 129.75;
            } else if (item == 3) {
                grossSales += 99.95;
            } else if (item == 4) {
                grossSales += 350.89;
            } else {
                System.out.println("Invalid item number. Please enter 1, 2, 3, or 4.");
            }
            
            System.out.print("Enter item number sold (1-4, or -1 to finish): ");
            item = input.nextInt();
        }
        
        double totalEarnings = 200.00 + (0.09 * grossSales);
        System.out.printf("%nGross Sales last week: $%.2f%n", grossSales);
        System.out.printf("Total Earnings: $%.2f%n", totalEarnings);
    }
}