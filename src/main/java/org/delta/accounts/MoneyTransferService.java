package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.print.AccountDetailPrinter;

@Singleton
public class MoneyTransferService {
    @Inject
    public TransferFeeCalculator transferFeeCalculator;

    @Inject
    public AccountDetailPrinter accountDetailPrinter;

    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        newBalance -= this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
    }

    public void transferMoney(BankAccount sender, BankAccount beneficiary, double amount) {
        double balance = sender.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

        if (balance < amount) {
            throw new NotEnoughMoneyException();
        }

        sender.setBalance(newBalance);
        beneficiary.setBalance(beneficiary.getBalance() + amount);
    }

    public void addMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        bankAccount.setBalance(newBalance);
    }

    public void deductMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        bankAccount.setBalance(newBalance);
    }

    public boolean hasSufficientFunds(BankAccount bankAccount, double amount) {
        return bankAccount.getBalance() >= amount;
    }
}
