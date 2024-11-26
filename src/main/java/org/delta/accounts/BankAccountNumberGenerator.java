package org.delta.accounts;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankAccountNumberGenerator implements AccountNumberGenerator {
    @Override
    public String generate() {
        Random random = new Random();

        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }
}
