package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.PaymentCard;
import org.delta.accounts.factories.PaymentCardFactory;
import org.delta.accounts.BankAccount;
import org.delta.accounts.factories.BankAccountFactory;
import org.delta.people.Owner;
import org.delta.people.OwnerFactory;
import org.delta.people.OwnerJsonSerializationService;
import org.delta.print.AccountDetailPrinter;

public class App {
    public void run() {
        runBank();
    }

    @Inject
    OwnerFactory ownerFactory;

    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    AccountDetailPrinter accountDetailPrinter;

    @Inject
    OwnerJsonSerializationService ownerJsonSerializationService;

    @Inject
    PaymentCardFactory debitCardFactory;

    void runBank() {



        // DAOs
        Owner owner1 = this.ownerFactory.createOwner("John", "Doe", "1234567890");
        BankAccount basicBankAccount = this.bankAccountFactory.createBankAccount(1000, owner1, true);

        // create a payment card
        PaymentCard paymentCard = this.debitCardFactory.createDebitCard();

        basicBankAccount.associatePaymentCard(paymentCard);

        // test
        this.accountDetailPrinter.printDetail(basicBankAccount);
    }
}
