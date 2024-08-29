import java.util.ArrayList;

public class BankAccount {

    public double balance;

    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Deposit amount should be positive!");
        }
    }
    public void withdraw(double amount){
        if(amount > 0){
            if (balance >= amount){
               balance = balance - amount;
            }
            else {
                System.out.println("Withdraw amount can not be higher than balance!");
            }

        }
        else {
            System.out.println("Withdraw amount should be positive!");
        }
    }
    protected static void transferFunds(BankAccount sender, BankAccount receiver, double amount){
        if (sender.balance >= amount){
            sender.withdraw(amount);
            receiver.deposit(amount);
        }
        else{
            System.out.println("Not enough funds in sender's account");
        }
    }
    public void printBalance(){
        System.out.println(this.balance + "€");
    }



    public static void printAccounts(ArrayList<BankAccount> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.print("Account ID " + (i+1) + ": ");
            accounts.get(i).printBalance();
        }
    }

}
