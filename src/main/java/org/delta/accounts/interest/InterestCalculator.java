package org.delta.accounts.interest;

import org.delta.accounts.SavingsAccount;

public class InterestCalculator {
    public double calculateInterest(SavingsAccount bankAccount) {
        return bankAccount.getBalance() * (bankAccount.getInterestRate() / 100);
    }
}
