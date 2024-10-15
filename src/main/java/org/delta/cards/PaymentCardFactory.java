package org.delta.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaymentCardFactory {
    @Inject
    CardNumberGenerator cardNumberGenerator;

    @Inject
    GlobalCardStorage globalCardStorage;

    @Inject
    PaymentCardPersonalIdentificationNumberGenerator paymentCardPersonalIdentificationNumberGenerator;


    public DebitCard createDebitCard() {
        DebitCard debitCard = new DebitCard(
                this.cardNumberGenerator.generate(),
                this.paymentCardPersonalIdentificationNumberGenerator.generate()
        );

        this.globalCardStorage.put(debitCard);

        return debitCard;
    }

    public PaymentCard findPaymentCard(String number) {
        return this.globalCardStorage.get(number);
    }
}
