package org.delta.cards;

import com.google.inject.Inject;

public class PaymentCardFacade {
    @Inject
    public PaymentCardFactory paymentCardFactory;

    @Inject
    public GlobalCardStorage globalCardStorage;
}
