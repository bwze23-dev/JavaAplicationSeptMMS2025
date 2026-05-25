public class Checkerboard {
    public static void main(String[] args) {
        int row = 1;
        
        while (row <= 8) {
            if (row % 2 == 0) {
                System.out.print(" ");
            }
            
            int col = 1;
            while (col <= 8) {
                System.out.print("* ");
                col++;
            }
            
            System.out.println();
            row++;
        }
    }
}