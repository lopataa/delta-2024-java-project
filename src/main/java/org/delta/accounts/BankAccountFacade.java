package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.cards.PaymentCard;
import org.delta.cards.PaymentCardFactory;
import org.delta.people.Owner;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public PaymentCardFactory paymentCardFactory;

    @Inject
    public MoneyTransferService moneyTransferService;

    public BankAccount createBankAccount(double balance, Owner owner) {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(balance, owner);
        PaymentCard paymentCard = paymentCardFactory.createDebitCard();

        bankAccount.associatePaymentCard(paymentCard);

        return bankAccount;
    }
}
