package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.BankAccountFacade;
import org.delta.cards.PaymentCard;
import org.delta.cards.PaymentCardFacade;
import org.delta.cards.PaymentCardFactory;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
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
    BankAccountFacade bankAccountFacade;

    @Inject
    PaymentCardFacade paymentCardFacade;

    @Inject
    AccountDetailPrinter accountDetailPrinter;

    @Inject
    OwnerJsonSerializationService ownerJsonSerializationService;

    @Inject
    AtmService atmService;

    void runBank() {



        Owner owner = ownerFactory.createOwner("John", "Doe", "11");
        BankAccount bankAccount = bankAccountFacade.bankAccountFactory.createBankAccount(1000, owner, true);

        atmService.deposit(bankAccount.getPaymentCards().getFirst(), 100);

        String cardNumber = bankAccount.getPaymentCards().getFirst().getNumber();
        atmService.withdraw(cardNumber, 50);


        accountDetailPrinter.printDetail(bankAccount);
    }
}
