import java.util.Scanner;

public class EvenCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

    
        String[] results = {"Even", "Odd"};

        
        int index = Math.abs(number % 2);

   
        System.out.println("The number " + number + " is: " + results[index]);

        
    }
}	
	
	
