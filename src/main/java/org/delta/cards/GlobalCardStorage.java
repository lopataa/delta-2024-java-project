package org.delta.cards;

import com.google.inject.Singleton;

import java.util.HashMap;

@Singleton
public class GlobalCardStorage {
    public HashMap<String, PaymentCard> paymentCards = new HashMap<String, PaymentCard>();

    public void put(PaymentCard card) {
        this.paymentCards.put(card.getNumber(), card);
    }

    public PaymentCard get(String number) {
        return this.paymentCards.get(number);
    }
}
