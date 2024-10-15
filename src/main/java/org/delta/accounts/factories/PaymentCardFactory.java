package org.delta.accounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.DebitCard;
import org.delta.accounts.GlobalCardStorage;
import org.delta.accounts.PaymentCard;
import org.delta.accounts.interfaces.CardNumberGenerator;
import org.delta.accounts.services.PaymentCardPersonalIdentificationNumberGenerator;

import java.util.HashMap;

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
