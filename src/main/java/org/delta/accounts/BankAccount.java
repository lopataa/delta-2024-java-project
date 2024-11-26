package org.delta.accounts;

import org.delta.cards.PaymentCard;
import org.delta.people.Owner;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;

    private Owner owner;

    private String accountNumber;

    private List<PaymentCard> paymentCards = new ArrayList<PaymentCard>();

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public void associatePaymentCard(PaymentCard paymentCard) {
        paymentCard.setBankAccount(this);
        this.paymentCards.add(paymentCard);
    }

    public List<PaymentCard> getPaymentCards() {
        return this.paymentCards;
    }

    public double getBalance() {
        return this.balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

