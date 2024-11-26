package org.delta;

import com.google.inject.Inject;
import org.delta.cards.GlobalCardStorage;
import org.delta.cards.PaymentCard;
import org.delta.accounts.MoneyTransferService;

public class AtmService {
    @Inject
    MoneyTransferService moneyTransferService;

    @Inject
    GlobalCardStorage globalCardStorage;

    public void withdraw(PaymentCard card, double amount) {
        moneyTransferService.withdrawMoney(card.getBankAccount(), amount);
    }

    public void deposit(PaymentCard card, double amount) {
        moneyTransferService.depositMoney(card.getBankAccount(), amount);
    }

    public void withdraw(String cardNumber, double amount) {
        PaymentCard card = globalCardStorage.get(cardNumber);

        moneyTransferService.withdrawMoney(card.getBankAccount(), amount);
    }

    public void deposit(String cardNumber, double amount) {
        PaymentCard card = globalCardStorage.get(cardNumber);

        moneyTransferService.depositMoney(card.getBankAccount(), amount);
    }
}
