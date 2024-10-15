package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.interfaces.CardNumberGenerator;
import org.delta.accounts.interfaces.PersonalIdentificationNumberGenerator;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.accounts.services.MastercardCardNumberGenerator;
import org.delta.accounts.services.PaymentCardPersonalIdentificationNumberGenerator;
import org.delta.accounts.services.SlovakianAccountNumberGenerator;

public class BankModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AccountNumberGenerator.class).to(BankAccountNumberGenerator.class);
        bind(CardNumberGenerator.class).to(MastercardCardNumberGenerator.class);
        bind(PersonalIdentificationNumberGenerator.class).to(PaymentCardPersonalIdentificationNumberGenerator.class);
    }
}
