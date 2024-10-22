package org.delta.accounts;

import com.google.inject.Singleton;
import org.delta.cards.PaymentCard;

import java.util.HashMap;

@Singleton
public class GlobalAccountStorage {
    public HashMap<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();

    public void put(BankAccount bankAccount) {
        this.bankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
    }

    public BankAccount get(String number) {
        return this.bankAccounts.get(number);
    }
}
