package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.example.Banking.BankAccount;
import org.example.Banking.BankingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        BankingService service = new BankingService();
//
//        BankAccount acc1 = new BankAccount(105);
//        BankAccount acc2 = new BankAccount(200);
//        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
//        accounts.add(acc1);
//        accounts.add(acc2);
//        accounts.add(new BankAccount(700));
//        String fileName = "accounts.txt";
//        String option;
//        String amount;
//        String selection;
//        String selection1;
//
//        Scanner myObj = new Scanner(System.in);
//
//        int j = 0;
//        while (j != 1) {
//            System.out.println();
//            System.out.println("Please select what you want to do:");
//            System.out.println("1.Select bank account to withdraw/deposit.");
//            System.out.println("2. Transfer funds from one account to another.");
//            System.out.println("3. Get accounts report.");
//            System.out.println("4. Exit");
//            option = myObj.nextLine();
//            switch (option) {
//                case "1":
//                    logger.debug("Debug log message");
//                    logger.info("Deposit/Withdraw selected");
//                    System.out.println("Please, select which bank account you want to work with:");
//                    BankingService.printAccounts(accounts,service);
//                    selection = myObj.nextLine();
//
//                    if (checkId(selection, accounts)) {
//                        int index = Integer.parseInt(selection) - 1;
//                        System.out.println("Selected bank account ID " + selection);
//                        System.out.println("Select what you want to do:");
//                        System.out.println("1. Deposit");
//                        System.out.println("2. Withdraw");
//                        selection = myObj.nextLine();
//                        switch (selection) {
//                            case "1":
//                                System.out.println("Enter amount you want to deposit.");
//                                amount = myObj.nextLine();
//                                service.deposit(accounts.get(index),Double.parseDouble(amount));
//                                break;
//                            case "2":
//                                System.out.println("Enter amount you want to withdraw.");
//                                amount = myObj.nextLine();
//                                service.withdraw(accounts.get(index),Double.parseDouble(amount));
//                                break;
//                            default:
//                                System.out.println("Entered invalid amount");
//                                break;
//
//                        }
//                        break;
//                    } else {
//                        break;
//                    }
//                case "2":
//                    System.out.println("Select from which account you want to send funds:");
//                    BankingService.printAccounts(accounts,service);
//                    selection = myObj.nextLine();
//                    System.out.println("Select to which account you want to send funds:");
//                    selection1 = myObj.nextLine();
//                    if (checkId(selection, accounts) && checkId(selection1, accounts)) {
//                        int index1 = Integer.parseInt(selection) - 1;
//                        int index2 = Integer.parseInt(selection1) - 1;
//                        System.out.println("Input amount you want to transfer.");
//                        amount = myObj.nextLine();
//                        BankingService.transferFunds(accounts.get(index1), accounts.get(index2), Double.parseDouble(amount),service);
//                    } else {
//                        break;
//                    }
//                    break;
//                case "3":
//                    try (FileWriter writer = new FileWriter(fileName)) {
//                        for (int i = 0; i < accounts.size(); i++) {
//                            writer.write("Account ID " + (i + 1) + ": " + accounts.get(i).getBalance() + "€\n");
//
//                        }
//                        System.out.println("File written successfully!");
//                    } catch (IOException e) {
//                        logger.error("Error log message");
//                        System.out.println("An error occurred while writing to the file.");
//                    }
//                default:
//                    System.out.println("Have a nice day!");
//                    return;
//            }
//        }


    }

    public static boolean checkId(String id, ArrayList<BankAccount> accounts) {
        try {
            int index = Integer.parseInt(id);
            int length = accounts.size();
            if (index <= length) {
                return true;
            } else {
                System.out.println("ID out of bounds.");
                return false;
            }
        } catch (NumberFormatException e) {
            logger.error("Invalid account");
            System.out.println("Entered Id is Invalid.");
            return false;
        }
    }

}