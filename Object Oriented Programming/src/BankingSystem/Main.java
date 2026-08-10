
package BankingSystem;

public class Main {
     public static void main(String[] args) {
        
        SavingsAccount savings = new SavingsAccount("S101", "Alice", 1000.0);
        CurrentAccount current = new CurrentAccount("C101", "Bob", 500.0);

        savings.deposit(200.0);
        savings.withdraw(150.0);
        savings.displayBalance();
        savings.calculateInterest();

        System.out.println(); 

        
        current.deposit(100.0);
        current.withdraw(700.0);
        current.displayBalance();
        current.calculateInterest();
    }
}
