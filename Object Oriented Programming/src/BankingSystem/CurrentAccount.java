
package BankingSystem;

public class CurrentAccount extends BankAccount {
     public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(accountHolder + " withdrew: $" + amount);
    }

    @Override
    public void calculateInterest() {
        System.out.println(accountHolder + "'s Current Interest: $0.0");
    }
}
