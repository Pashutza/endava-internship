package org.internship.account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {
    private int idHolder;
    private static BigDecimal annualInterestRate = new BigDecimal("0");
    private static BigDecimal monthlyInterest = new BigDecimal("0");
    private BigDecimal savingsBalance = new BigDecimal("0");

    public SavingsAccount(BigDecimal savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public BigDecimal getSavingsBalance() {
        return savingsBalance;
    }

    private void addBalance(BigDecimal addAmount) {
        this.savingsBalance = savingsBalance.add(addAmount);
    }

    private void minusBalance(BigDecimal minusAmount) {
        this.savingsBalance = savingsBalance.subtract(minusAmount);
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance = savingsBalance.add(getMonthlyInterest());
    }

    public BigDecimal getMonthlyInterest() {
        return (savingsBalance.multiply(annualInterestRate)).divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
    }

    public static void modifyInterestRate(BigDecimal newValue) {
        annualInterestRate = newValue;

    }

    public void transferFundsTo(SavingsAccount anotherDeposit, BigDecimal amountTransferred) {
        minusBalance(amountTransferred);
        anotherDeposit.addBalance(amountTransferred);
    }


}
