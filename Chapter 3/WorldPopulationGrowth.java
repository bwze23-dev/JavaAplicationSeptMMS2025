import java.util.Scanner;

public class WorldPopulationGrowth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter estimated current world population (e.g., 8050000000): ");
        long initialPopulation = input.nextLong();
        
        System.out.print("Enter annual growth rate as a percentage (e.g., 0.9): ");
        double growthRatePercent = input.nextDouble();
        double growthRate = growthRatePercent / 100.0;
        
        long currentPopulation = initialPopulation;
        int doublingYear = -1;
        
        System.out.printf("%n%-5s\t%-25s\t%-20s%n", "Year", "Anticipated Population", "Numerical Increase");
        System.out.println("-----------------------------------------------------------------");
        
        for (int year = 1; year <= 75; year++) {
            long previousPopulation = currentPopulation;
            currentPopulation = (long) (previousPopulation * (1.0 + growthRate));
            long annualIncrease = currentPopulation - previousPopulation;
            
            System.out.printf("%-5d\t%-25d\t%-20d%n", year, currentPopulation, annualIncrease);
            
            
            if (currentPopulation >= (2 * initialPopulation) && doublingYear == -1) {
                doublingYear = year;
            }
        }
        
        System.out.println("-----------------------------------------------------------------");
        if (doublingYear != -1) {
            System.out.printf("The world population will double from today's value in year: %d%n", doublingYear);
        } else {
            System.out.println("The population does not double within the 75-year prediction threshold.");
        }
    }
}