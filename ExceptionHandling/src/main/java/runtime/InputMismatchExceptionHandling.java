
package runtime;

import java.util.Scanner;

public class InputMismatchExceptionHandling {
    public static void main(String[] args){
        Scanner input = new Scanner("System.in");
        
        try{
            System.out.println("Enter your age: ");
            int age = input.nextInt();
        
            System.out.printf("Your are %d years old",age);
        }
        catch(InputMismatchException e){
            System.out.println("Age is a number");
        }
        
    }
}
