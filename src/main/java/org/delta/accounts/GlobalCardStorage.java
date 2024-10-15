package org.delta.accounts;

import java.util.HashMap;

public class GlobalCardStorage {
    public HashMap<String, PaymentCard> paymentCards = new HashMap<String, PaymentCard>();

    public void put(PaymentCard card) {
        this.paymentCards.put(card.getNumber(), card);
    }

    public PaymentCard get(String number) {
        return this.paymentCards.get(number);
    }
}
