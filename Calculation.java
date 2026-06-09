public class Calculation {
    public static void main(String[] args) {
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
         
        int sum1 = numbers[0] + numbers[4] + numbers[9]; 
        int sum2 = numbers[2] + numbers[7] + numbers[1];  
        int product = sum1 * sum2;
        
        int sum3 = numbers[3] + numbers[6] + numbers[5] + numbers[8];
        int result = sum3 - product;
        
        
        if (result >= 100) {
            System.out.println("hurray I did it");
        } else {
            System.out.println("I still need to learn more in Java");
        }
    }
}