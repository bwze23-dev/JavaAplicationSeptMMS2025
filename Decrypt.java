mport java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a 4-digit encrypted integer to decrypt: ");
        int number = input.nextInt();
        
        int digit1 = number / 1000;
        int digit2 = (number % 1000) / 100;
        int digit3 = (number % 100) / 10;
        int digit4 = number % 10;
        
       
        int temp;
        
        temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        
       
        digit1 = (digit1 + 3) % 10;
        digit2 = (digit2 + 3) % 10;
        digit3 = (digit3 + 3) % 10;
        digit4 = (digit4 + 3) % 10;
        
        System.out.printf("Decrypted original data: %d%d%d%d%n", digit1, digit2, digit3, digit4);
    }
}