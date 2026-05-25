public class TabularOutput {
    public static void main(String[] args) {
        System.out.printf("%-5s\t%-5s\t%-5s\t%-5s%n", "N", "10*N", "100*N", "1000*N");
        
        int n = 1;
        while (n <= 5) {
            System.out.printf("%-5d\t%-5d\t%-5d\t%-5d%n", n, 10 * n, 100 * n, 1000 * n);
            n++;
        }
    }
}