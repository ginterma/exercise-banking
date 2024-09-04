package org.example.Banking;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table
public class BankAccount {

    public BankAccount(double balance, String name, Long id) {
        this.balance = balance;
        this.name = name;
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    private double balance;
    private String name;
    @Id
    @SequenceGenerator( name = "account_sequence",
    sequenceName = "account_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_sequence")
    private Long id;
    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }



}
