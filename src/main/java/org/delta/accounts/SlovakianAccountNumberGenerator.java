package org.delta.accounts;

import com.google.inject.Singleton;

@Singleton
public class SlovakianAccountNumberGenerator implements AccountNumberGenerator {
    @Override
    public String generate() {
        return "slovakian";
    }
}
