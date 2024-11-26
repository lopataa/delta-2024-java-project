package org.delta.accounts;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.BankModule;
import org.delta.cards.PaymentCard;
import org.delta.cards.PaymentCardFactory;
import org.delta.people.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountFactoryTest {
    Injector i = Guice.createInjector(new BankModule());

    private BankAccountFactory bankAccountFactory;
    private OwnerFactory ownerFactory;
    private PaymentCardFactory paymentCardFactory;

    @BeforeEach
    void setUp() {
        bankAccountFactory = i.getInstance(BankAccountFactory.class);
        ownerFactory = i.getInstance(OwnerFactory.class);
        paymentCardFactory = i.getInstance(PaymentCardFactory.class);
    }

    @Test
    void createBankAccount() {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(100, ownerFactory.createOwner("John", "Doe", "11"));
        PaymentCard paymentCard = paymentCardFactory.createDebitCard();
        bankAccount.associatePaymentCard(paymentCard);
        assertEquals(100, bankAccount.getBalance());
        assertEquals("John", bankAccount.getOwner().getFirstname());
        assertEquals("Doe", bankAccount.getOwner().getLastname());
        assertEquals(paymentCard, bankAccount.getPaymentCards().getFirst());
    }

    @Test
    void createStudentBankAccount() {
        BankAccount bankAccount = bankAccountFactory.createStudentBankAccount(100, ownerFactory.createOwner("John", "Doe", "11"));
        assertEquals(100, bankAccount.getBalance());
        assertEquals("John", bankAccount.getOwner().getFirstname());
        assertEquals("Doe", bankAccount.getOwner().getLastname());
    }

    @Test
    void createSavingBankAccount() {

    }

    @Test
    void createInvestmentAccount() {
    }
}