package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.cards.PaymentCardFactory;
import org.delta.cards.GlobalCardStorage;

public class BankAccountFacade {
    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public PaymentCardFactory paymentCardFactory;

    @Inject
    public MoneyTransferService moneyTransferService;
}
