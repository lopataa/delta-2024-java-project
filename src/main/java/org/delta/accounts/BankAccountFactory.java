package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.cards.PaymentCardFactory;
import org.delta.people.Owner;

@Singleton
public class BankAccountFactory {
    @Inject
    public AccountNumberGenerator bankAccountNumberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner) {
        BankAccount bankAccount = new BankAccount(balance, owner, bankAccountNumberGenerator.generate());

        return bankAccount;
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(balance, owner, accountNumber);
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner) {
        return new BankAccount(balance, owner, bankAccountNumberGenerator.generate());
    }
}
