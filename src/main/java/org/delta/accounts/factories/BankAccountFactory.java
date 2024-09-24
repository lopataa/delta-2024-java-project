package org.delta.accounts.factories;

import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.BankAccount;
import org.delta.people.Owner;

public class BankAccountFactory {
    public AccountNumberGenerator bankAccountNumberGenerator;

    public BankAccountFactory(AccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
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
    }
}
