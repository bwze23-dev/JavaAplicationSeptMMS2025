
package encapsulation;


   public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", "Alice Smith", 500.00);
        account.displayDetails();
        
        account.deposit(250.00);
        account.withdraw(100.00);
        account.withdraw(700.00); 
    }
}
    




