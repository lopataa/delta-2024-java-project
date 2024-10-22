package org.delta.cards;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.people.Owner;

public class PaymentCardFacade {
    @Inject
    public PaymentCardFactory paymentCardFactory;

    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    public GlobalCardStorage globalCardStorage;


}
