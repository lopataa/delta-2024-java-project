package org.delta.serialization;

import com.google.inject.Singleton;

@Singleton
public class BankJsonDataFactory {
    public BankJsonData create() {
        return new BankJsonData();
    }
}
