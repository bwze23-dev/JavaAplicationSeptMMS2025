import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int totalMiles = 0;
        int totalGallons = 0;
        
        System.out.print("Enter miles driven (-1 to quit): ");
        int miles = input.nextInt();
        
        while (miles != -1) {
            System.out.print("Enter gallons used: ");
            int gallons = input.nextInt();
            
            totalMiles += miles;
            totalGallons += gallons;
            
            if (gallons != 0) {
                double tripMpg = (double) miles / gallons;
                System.out.printf("Trip MPG: %.2f%n", tripMpg);
            } else {
                System.out.println("Gallons cannot be zero.");
            }
            
            double totalMpg = (double) totalMiles / totalGallons;
            System.out.printf("Combined MPG up to this point: %.2f%n%n", totalMpg);
            
            System.out.print("Enter miles driven (-1 to quit): ");
            miles = input.nextInt();
        }
        System.out.println("Program closed.");
    }
}