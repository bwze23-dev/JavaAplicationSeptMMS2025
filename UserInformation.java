import java.util.Scanner;

public class UserInformation {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        scanner.nextLine(); 

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

       
        System.out.println("\n---------------------------------");
        System.out.println("        USER PROFILE CARD        ");
        System.out.println("---------------------------------");
        System.out.printf("Name:    %s%n", name);
        System.out.printf("Age:     %d years old%n", age);
        System.out.printf("Address: %s%n", address);
        System.out.println("---------------------------------");
		
    }
}