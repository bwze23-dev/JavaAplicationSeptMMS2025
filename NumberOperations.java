import java.util.Scanner;

public class NumberOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 numbers one by one:");
		double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        double num4 = scanner.nextDouble();
        double num5 = scanner.nextDouble();

     
        double sum = num1 + num2 + num3 + num4 + num5;
        double average = sum / 5;
        double product = num1 * num2 * num3 * num4 * num5;

        
        System.out.println("\n--- Results ---");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Product: " + product);

        
    }
}