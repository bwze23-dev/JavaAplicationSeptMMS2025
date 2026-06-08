import java.util.Scanner;

public class FairTaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("FairTax Alternative Estimation Tool");
        System.out.println("------------------------------------");

        System.out.print("Enter housing expenses: $");
        double housing = input.nextDouble();
        
        System.out.print("Enter food expenses: $");
        double food = input.nextDouble();

        System.out.print("Enter clothing expenses: $");
        double clothing = input.nextDouble();

        System.out.print("Enter transportation expenses: $");
        double transport = input.nextDouble();

        System.out.print("Enter education expenses: $");
        double education = input.nextDouble();

        System.out.print("Enter health care expenses: $");
        double health = input.nextDouble();

        System.out.print("Enter vacation/leisure expenses: $");
        double vacation = input.nextDouble();

        double totalExpenses = housing + food + clothing + transport + education + health + vacation;
        
    
       
        double fairTaxInclusive = totalExpenses * 0.23;
        double fairTaxExclusive = totalExpenses * 0.30;

        System.out.println("\n--- FairTax Summary ---");
        System.out.printf("Total Retail Expenditures: $%,.2f%n", totalExpenses);
        System.out.printf("Estimated FairTax (23%% Inclusive Rate): $%,.2f%n", fairTaxInclusive);
        System.out.printf("Estimated FairTax (30%% Exclusive Rate Alternative): $%,.2f%n", fairTaxExclusive);
    }
}