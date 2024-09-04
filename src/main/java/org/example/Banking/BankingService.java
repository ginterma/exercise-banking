package org.example.Banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BankingService {

    private final BankingRepository bankingRepository;

    @Autowired
    public BankingService(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    }

    public void deposit(BankAccount acc, double amount) {
        if (amount > 0) {
            acc.setBalance(acc.getBalance() + amount);
        } else {
            System.out.println("Deposit amount should be positive!");
        }
    }

    public void withdraw(BankAccount acc, double amount) {
        if (amount > 0) {
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
            } else {
                System.out.println("Withdraw amount can not be higher than balance!");
            }

        } else {
            System.out.println("Withdraw amount should be positive!");
        }
    }

    public static void transferFunds(BankAccount sender, BankAccount receiver, double amount, BankingService service) {
        if (sender.getBalance() >= amount) {
            service.withdraw(sender, amount);
            service.deposit(receiver, amount);
        } else {
            System.out.println("Not enough funds in sender's account");
        }
    }

    public void printBalance(BankAccount acc) {
        System.out.println(acc.getBalance() + "€");
    }


    public void printAccounts(ArrayList<BankAccount> accounts, BankingService service) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.print("Account ID " + (i + 1) + ": ");
            service.printBalance(accounts.get(i));
        }
    }

    public List<BankAccount> GetAccounts() {
        return bankingRepository.findAll();
    }

    public void addNewBankAccount(BankAccount bankAccount) {
        bankingRepository.save(bankAccount);
    }

    public void deleteAccount(Long id) {
        boolean exists = bankingRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Bank account with Id " + id + " does not exist");
        } else {
            bankingRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateName(Long bankingId,
                           String name) {
        BankAccount account = bankingRepository.findById(bankingId).orElseThrow(() -> new IllegalStateException(
                "account with Id " + bankingId + " does not exist."));
        if (name != null && !name.isEmpty() && !Objects.equals(account.getName(), name)) {
            account.setName(name);
        }

    }
    @Transactional
    public void updateBalance(Long bankingId, Double amount, String action){
        BankAccount account = bankingRepository.findById(bankingId).orElseThrow(() -> new IllegalStateException(
                "account with Id " + bankingId + " does not exist."));
        System.out.println("here");
        if(amount > 0){
            System.out.println(action);
            if (Objects.equals(action, "deposit")){
                System.out.println("here2");
                account.setBalance(account.getBalance() + amount);
            }
            if(Objects.equals(action, "withdraw")){
                System.out.println("here4");
                if(account.getBalance() >= amount){
                    account.setBalance(account.getBalance() - amount);
                }
            }
        }
    }
}
