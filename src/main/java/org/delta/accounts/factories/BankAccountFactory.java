package org.delta.accounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.BankAccount;
import org.delta.people.Owner;

@Singleton
public class BankAccountFactory {
    @Inject
    public AccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    PaymentCardFactory paymentCardFactory;

    public BankAccount createBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount bankAccount = new BankAccount(balance, owner, bankAccountNumberGenerator.generate());

        if(withCard) {
            bankAccount.associatePaymentCard(paymentCardFactory.createDebitCard());
        }

        return bankAccount;
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(balance, owner, accountNumber);
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner) {
        return new BankAccount(balance, owner, bankAccountNumberGenerator.generate());
    }
}
