package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.services.SlovakianAccountNumberGenerator;

public class BankModule extends AbstractModule {
    @Override
    protected void configure() {
        // bind(AccountNumberGenerator.class).to(BankAccountNumberGenerator.class);
        bind(AccountNumberGenerator.class).to(SlovakianAccountNumberGenerator.class);
    }
}
