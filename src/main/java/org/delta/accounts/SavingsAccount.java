package org.delta.accounts;

import org.delta.people.Owner;

import java.util.Date;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    private long lastInterestedAt;

    public SavingsAccount(double balance, Owner owner, String accountNumber, double interestRate) {
        super(balance, owner, accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public long getLastInterestedAt() {
        return lastInterestedAt;
    }

    public void setLastInterestedAt(long lastInterestedAt) {
        this.lastInterestedAt = lastInterestedAt;
    }

}