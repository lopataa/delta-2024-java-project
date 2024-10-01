package org.delta;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.BankAccount;
import org.delta.accounts.factories.BankAccountFactory;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.accounts.services.MoneyTransferService;
import org.delta.accounts.services.SlovakianAccountNumberGenerator;
import org.delta.accounts.services.TransferFeeCalculator;
import org.delta.people.Owner;
import org.delta.people.OwnerFactory;
import org.delta.people.OwnerJsonSerializationService;
import org.delta.people.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

public class App {
    public void run() {
        runBank();
    }

    @Inject
    private DIContainer services;

    void runBank() {

        // DAOs
        Owner owner1 = services.getOwnerFactory().createOwner("John", "Doe", "1234567890");
        BankAccount basicBankAccount = services.getBankAccountFactory().createBankAccount(1000, owner1);
        BankAccount studentBankAccount = services.getBankAccountFactory().createStudentBankAccount(1000, owner1);

        System.out.println(new OwnerJsonSerializationService(services.getGson()).serializeOwner(owner1));

        // test
        services.getAccountDetailPrinter().printDetail(basicBankAccount);
        services.getAccountDetailPrinter().printDetail(studentBankAccount);
    }
}
