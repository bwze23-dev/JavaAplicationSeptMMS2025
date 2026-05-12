import java.util.Scanner;

public class PopulationGrowth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter current world population: ");
        double population = input.nextDouble();

        System.out.print("Enter annual growth rate (e.g. 0.9 for 0.9%): ");
        double rate = input.nextDouble();

        double growthRate = 1 + (rate / 100);

        System.out.println("\nEstimated World Population:");
        System.out.printf("After 1 year:  %.0f%n", population * growthRate);
        System.out.printf("After 2 years: %.0f%n", population * growthRate * growthRate);
        System.out.printf("After 3 years: %.0f%n", population * growthRate * growthRate * growthRate);
        System.out.printf("After 4 years: %.0f%n", population * growthRate * growthRate * growthRate * growthRate);
        System.out.printf("After 5 years: %.0f%n", population * growthRate * growthRate * growthRate * growthRate * growthRate);
    }
}