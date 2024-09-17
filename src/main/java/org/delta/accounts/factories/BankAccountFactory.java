package org.delta.accounts.factories;

import org.delta.accounts.BankAccount;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.people.Owner;

public class BankAccountFactory {
    public BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccountFactory() {
        this.bankAccountNumberGenerator = new BankAccountNumberGenerator();
    }

    public BankAccount createBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(balance, owner, accountNumber);
    }

    public BankAccount createBankAccount(double balance, Owner owner) {
        return new BankAccount(balance, owner, bankAccountNumberGenerator.generateAccountNumber());
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(balance, owner, accountNumber);
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner) {
        return new BankAccount(balance, owner, bankAccountNumberGenerator.generateAccountNumber());
    };
}
