import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a 4-digit integer to encrypt: ");
        int number = input.nextInt();
        
        int digit1 = number / 1000;
        int digit2 = (number % 1000) / 100;
        int digit3 = (number % 100) / 10;
        int digit4 = number % 10;
        
        
        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;
        
        
        int temp;
        
        temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        
        System.out.printf("Encrypted representation: %d%d%d%d%n", digit1, digit2, digit3, digit4);
    }
}