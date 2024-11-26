package org.delta.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class MastercardCardNumberGenerator implements CardNumberGenerator {
    @Inject
    public Random random;

    @Override
    public String generate() {
        StringBuilder cardNumberBuilder = new StringBuilder();
        // add 5 as an prefix of the card cuz its an mastercard
        cardNumberBuilder.append("5");

        for (int i = 0; i < 15; i++) {
            cardNumberBuilder.append(random.nextInt(10));
        }

        return cardNumberBuilder.toString();
    }
}
