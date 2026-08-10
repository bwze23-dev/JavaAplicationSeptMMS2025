
package BankingSystem;

public abstract class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited: $" + amount);
    }

    public void displayBalance() {
        System.out.println(accountHolder + "'s Current Balance: $" + balance);
    }

   
    public abstract void withdraw(double amount);
    public abstract void calculateInterest();
    
}

