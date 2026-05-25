import java.util.Scanner;

public class ValidateInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        
        while (value != 1 && value != 2) {
            System.out.print("Enter value (1 or 2): ");
            value = input.nextInt();
            
            if (value != 1 && value != 2) {
                System.out.println("Error: Invalid entry. You must enter either 1 or 2.");
            }
        }
        
        System.out.printf("Input successfully validated: %d%n", value);
    }
}