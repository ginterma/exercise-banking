package org.example;


import org.example.Banking.BankAccount;
import org.example.Banking.BankingService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    BankingService service;
    @Test
    @DisplayName("Tests deposit method")
    public void  deposit() {
        BankAccount acc = new BankAccount(500);
        service.deposit(acc,-70000000);
        service.deposit(acc,200);
        assertEquals(700, acc.getBalance());
    }

    @Test
    @DisplayName("Tests withdraw method")
    public void withdraw() {

        BankAccount acc = new BankAccount(275);
        service.withdraw(acc,200);
        assertEquals(75, acc.getBalance());
        BankAccount acc1 = new BankAccount(100);
        service.withdraw(acc,150);
        service.withdraw(acc,-150);


        assertAll(() -> assertEquals(75, acc.getBalance()),
                () -> assertEquals(100, acc1.getBalance()),
                () -> assertEquals(100, acc1.getBalance()));

    }

    @Test
    @DisplayName("Test transfer funds method between two accounts")
    public void transferFunds(){
        BankAccount acc1 = new BankAccount(50);
        BankAccount acc2 = new BankAccount(770);
        BankingService.transferFunds(acc1,acc2,70,service);
        BankingService.transferFunds(acc1,acc2,-70,service);
        BankingService.transferFunds(acc1,acc2,20,service);
        assertAll(() -> assertEquals(30, acc1.getBalance()),
                () -> assertEquals(790, acc2.getBalance()));
    }
}
