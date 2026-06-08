import java.util.Scanner;

public class SmallestValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of values you want to input: ");
        int numValues = input.nextInt();
        
        if (numValues <= 0) {
            System.out.println("No values to process.");
            return;
        }

        System.out.print("Enter integer 1: ");
        int smallest = input.nextInt(); 

        for (int i = 2; i <= numValues; i++) {
            System.out.printf("Enter integer %d: ", i);
            int current = input.nextInt();
            if (current < smallest) {
                smallest = current;
            }
        }

        System.out.printf("The smallest integer is: %d%n", smallest);
    }
}