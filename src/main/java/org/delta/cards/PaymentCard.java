package org.delta.cards;

import org.delta.accounts.BankAccount;

public class PaymentCard {
    private String number;
    private String personalIdentificationNumber;
    private transient BankAccount bankAccount;

    public PaymentCard(String cardNumber, String cardPIN) {
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("card number too short bro sorry m8");
        }

        this.number = cardNumber;
        this.personalIdentificationNumber = cardPIN;
    }

    public String getNumber() {
        return number;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }
}
