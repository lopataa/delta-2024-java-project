package org.delta.accounts.services;

import com.google.inject.Inject;
import org.delta.accounts.PaymentCard;

public class AtmService {
    @Inject
    MoneyTransferService moneyTransferService;

    public void withdraw(PaymentCard card, double amount) {
        moneyTransferService.withdrawMoney(card.getBankAccount(), amount);
    }

    public void deposit(PaymentCard card, double amount) {
        moneyTransferService.depositMoney(card.getBankAccount(), amount);
    }
}
