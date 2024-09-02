package org.example;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    @DisplayName("Tests deposit method")
    public void  deposit() {
        BankAccount acc = new BankAccount(500);
        acc.deposit(-70000000);
        acc.deposit(200);
        assertEquals(700, acc.balance);
    }

    @Test
    @DisplayName("Tests withdraw method")
    public void withdraw() {

        BankAccount acc = new BankAccount(275);
        acc.withdraw(200);
        assertEquals(75, acc.balance);
        BankAccount acc1 = new BankAccount(100);
        acc1.withdraw(150);
        acc1.withdraw(-150);


        assertAll(() -> assertEquals(75, acc.balance),
                () -> assertEquals(100, acc1.balance),
                () -> assertEquals(100, acc1.balance));

    }

    @Test
    @DisplayName("Test transfer funds method between two accounts")
    public void transferFunds(){
        BankAccount acc1 = new BankAccount(50);
        BankAccount acc2 = new BankAccount(770);
        BankAccount.transferFunds(acc1,acc2,70);
        BankAccount.transferFunds(acc1,acc2,-70);
        BankAccount.transferFunds(acc1,acc2,20);
        assertAll(() -> assertEquals(30, acc1.balance),
                () -> assertEquals(790, acc2.balance));
    }
}
