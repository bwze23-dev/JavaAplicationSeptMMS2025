import java.util.Scanner;

public class FindTwoLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int counter = 0;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        while (counter < 10) {
            System.out.print("Enter an integer: ");
            int number = input.nextInt();
            
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
            
            counter++;
        }
        
        System.out.printf("Largest integer: %d%n", largest);
        System.out.printf("Second largest integer: %d%n", secondLargest);
    }
}