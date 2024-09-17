package org.delta.accounts;

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
}
