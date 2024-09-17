package org.delta.accounts.services;

import org.delta.accounts.BankAccount;
import org.delta.accounts.exceptions.NotEnoughMoneyException;
import org.delta.print.AccountDetailPrinter;

public class MoneyTransferService {

    public TransferFeeCalculator transferFeeCalculator;
    public AccountDetailPrinter accountDetailPrinter;

    public MoneyTransferService() {
        this.transferFeeCalculator = new TransferFeeCalculator();
        this.accountDetailPrinter = new AccountDetailPrinter();
    }


    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        newBalance -= this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void transferMoney(BankAccount sender, BankAccount beneficiary, double amount) {
        double balance = sender.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

        if(balance < amount) {
            throw new NotEnoughMoneyException();
        }

        sender.setBalance(newBalance);
        beneficiary.setBalance(beneficiary.getBalance() + amount);
        accountDetailPrinter.printDetail(sender);
        accountDetailPrinter.printDetail(beneficiary);
    }
}
