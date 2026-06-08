public class Factorials {
    public static void main(String[] args) {
        System.out.printf("%-5s%s%n", "n", "n!");
        System.out.println("---------------------------");

        long factorial = 1;
        for (int i = 1; i <= 20; i++) {
            factorial *= i;
            System.out.printf("%-5d%d%n", i, factorial);
        }
    }
}