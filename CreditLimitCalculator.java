import java.util.Scanner;

public class CreditLimitCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter account number (-1 to quit): ");
        int account = input.nextInt();
        
        while (account != -1) {
            System.out.print("Enter beginning balance: ");
            int beginningBalance = input.nextInt();
            
            System.out.print("Enter total charges this month: ");
            int charges = input.nextInt();
            
            System.out.print("Enter total credits this month: ");
            int credits = input.nextInt();
            
            System.out.print("Enter allowed credit limit: ");
            int creditLimit = input.nextInt();
            
            int newBalance = beginningBalance + charges - credits;
            System.out.printf("New balance for account %d: %d%n", account, newBalance);
            
            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded");
            }
            System.out.println();
            
            System.out.print("Enter account number (-1 to quit): ");
            account = input.nextInt();
        }
    }
}