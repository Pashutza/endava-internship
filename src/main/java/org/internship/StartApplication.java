package org.internship;

import org.internship.account.Bank;
import org.internship.account.SavingsAccount;

import java.math.BigDecimal;

public class StartApplication {
    public static void main(String[] args) {
        System.out.println("Start application");

        SavingsAccount.modifyInterestRate(new BigDecimal("0.04"));
        SavingsAccount deposit1 = new SavingsAccount(new BigDecimal("2000"));
        SavingsAccount deposit2 = new SavingsAccount(new BigDecimal("3000"));
        SavingsAccount deposit3 = new SavingsAccount(new BigDecimal("2000"));
        SavingsAccount deposit4 = new SavingsAccount(new BigDecimal("3000"));

        System.out.println("The current balance for deposit1 is: " + deposit1.getSavingsBalance());
        deposit1.calculateMonthlyInterest();

        System.out.println("The balance changed by 4% for deposit1 is: " + deposit1.getSavingsBalance());

        System.out.println("The current balance for deposit2 is: " + deposit2.getSavingsBalance());
        deposit2.calculateMonthlyInterest();
        System.out.println("The balance changed by 4% for deposit2 is: " + deposit2.getSavingsBalance());

        SavingsAccount.modifyInterestRate(new BigDecimal("0.05"));

        deposit1.calculateMonthlyInterest();
        System.out.println("The balance changed by 5% for deposit1 is: " + deposit1.getSavingsBalance());

        deposit2.calculateMonthlyInterest();
        System.out.println("The balance changed by 5% for deposit2 is: " + deposit2.getSavingsBalance());


        deposit1.transferFundsTo(deposit2, new BigDecimal("700"));

        System.out.println("Account1 after the transfer will have the amount of: " + deposit1.getSavingsBalance());
        System.out.println("Account2 after the transfer will have the amount of: " + deposit2.getSavingsBalance());
        Bank bank = new Bank(new BigDecimal("0.04"));

        bank.getDeposits().add(deposit3);
        bank.getDeposits().add(deposit4);
        bank.calculateGlobalMonthlyInterest();
    }


}

