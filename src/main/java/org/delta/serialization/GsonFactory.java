package org.delta.serialization;

import com.google.gson.GsonBuilder;
import org.delta.accounts.BankAccount;
import org.delta.serialization.adapters.BankAccountAdapter;

public class GsonFactory {
    public com.google.gson.Gson create() {
        return new GsonBuilder()
                .registerTypeAdapter(BankAccount.class, new BankAccountAdapter())
                .create();
    }
}
