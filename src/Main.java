//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(105);
        acc1.deposit(100);
        System.out.println(acc1.balance);

        BankAccount acc2 = new BankAccount(200);

        acc2.printBalance();

        BankAccount.transferFunds(acc1,acc2,37);
        acc1.printBalance();
        acc2.printBalance();
    }
}