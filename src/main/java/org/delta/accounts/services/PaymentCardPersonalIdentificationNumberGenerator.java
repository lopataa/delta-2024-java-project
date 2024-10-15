package org.delta.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.interfaces.PersonalIdentificationNumberGenerator;

import java.util.Random;

@Singleton
public class PaymentCardPersonalIdentificationNumberGenerator implements PersonalIdentificationNumberGenerator {
    @Inject
    Random random;

    @Override
    public String generate() {
        StringBuilder cardNumberBuilder = new StringBuilder();

        // add 5 as an prefix of the card cuz its an mastercard
        for (int i = 0; i < 4; i++) {
            cardNumberBuilder.append(random.nextInt(10));
        }

        return cardNumberBuilder.toString();
    }
}
