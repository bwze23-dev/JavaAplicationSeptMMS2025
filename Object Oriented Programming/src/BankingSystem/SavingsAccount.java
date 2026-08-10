
package BankingSystem;


public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds for " + accountHolder);
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.05; // 5% interest
        System.out.println(accountHolder + "'s Savings Interest (5%): $" + interest);
    }
     
}
