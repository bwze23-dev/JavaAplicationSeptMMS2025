import java.util.Scanner;

public class FindLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int counter = 0; 
        int number;      
        int largest = Integer.MIN_VALUE; 
        
        while (counter < 10) {
            System.out.print("Enter an integer: ");
            number = input.nextInt();
            
            if (number > largest) {
                largest = number;
            }
            
            counter++;
        }
        
        System.out.printf("The largest integer found is: %d%n", largest);
    }
}