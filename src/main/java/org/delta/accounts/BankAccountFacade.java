package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.cards.PaymentCard;
import org.delta.cards.PaymentCardFactory;
import org.delta.people.Owner;
import org.delta.investment.InvestmentAccount;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public PaymentCardFactory paymentCardFactory;

    public BankAccount createBankAccount(double balance, Owner owner) {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(balance, owner);
        PaymentCard paymentCard = paymentCardFactory.createDebitCard();

        bankAccount.associatePaymentCard(paymentCard);

        return bankAccount;
    }

    public SavingsAccount createSavingBankAccount(double balance, Owner owner, String accountNumber) {
        SavingsAccount account = bankAccountFactory.createSavingBankAccount(balance, owner, accountNumber, 4);

        return account;
    }

    public InvestmentAccount createInvestmentAccount(double balance, Owner owner, String accountNumber) {
        System.out.println(balance);
        InvestmentAccount account = bankAccountFactory.createInvestmentAccount(balance, owner, accountNumber);

        System.out.println("Investment account created with balance: " + account.getBalance());

        return account;
    }
}
