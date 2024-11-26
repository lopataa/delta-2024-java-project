package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.cards.CardNumberGenerator;
import org.delta.cards.PersonalIdentificationNumberGenerator;
import org.delta.accounts.BankAccountNumberGenerator;
import org.delta.cards.MastercardCardNumberGenerator;
import org.delta.cards.PaymentCardPersonalIdentificationNumberGenerator;

public class BankModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AccountNumberGenerator.class).to(BankAccountNumberGenerator.class);
        bind(CardNumberGenerator.class).to(MastercardCardNumberGenerator.class);
        bind(PersonalIdentificationNumberGenerator.class).to(PaymentCardPersonalIdentificationNumberGenerator.class);
    }
}
