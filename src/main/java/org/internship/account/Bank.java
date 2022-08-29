package org.internship.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<SavingsAccount> deposits = new ArrayList<>();

    public List<SavingsAccount> getDeposits() {
        return deposits;
    }

    public Bank(BigDecimal interestRate) {
        SavingsAccount.modifyInterestRate(interestRate);
    }

    public void calculateGlobalMonthlyInterest() {
        BigDecimal sumOfMoneyOnAllAccounts = BigDecimal.ZERO;
        BigDecimal sumOfAmountInterest = BigDecimal.ZERO;
        BigDecimal sumTotal = BigDecimal.ZERO;
        for (SavingsAccount deposit : deposits) {
            deposit.getMonthlyInterest();
            sumOfMoneyOnAllAccounts = sumOfMoneyOnAllAccounts.add(deposit.getSavingsBalance());
            sumOfAmountInterest = sumOfAmountInterest.add(deposit.getMonthlyInterest());
            deposit.calculateMonthlyInterest();
            sumTotal = sumTotal.add(deposit.getSavingsBalance());
        }
        System.out.println("The total amount of money on all accounts are: " + sumOfMoneyOnAllAccounts);
        System.out.println("The total amount of interest are: " + sumOfAmountInterest);
        System.out.println("The total amound: " + sumTotal);
    }
}
