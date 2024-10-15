package org.delta.accounts.services;

import com.google.inject.Singleton;
import org.delta.accounts.interfaces.AccountNumberGenerator;

@Singleton
public class SlovakianAccountNumberGenerator implements AccountNumberGenerator {
    @Override
    public String generate() {
        return "slovakian";
    }
}
