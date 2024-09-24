package org.delta;

import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.BankAccount;
import org.delta.accounts.factories.BankAccountFactory;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.accounts.services.MoneyTransferService;
import org.delta.accounts.services.TransferFeeCalculator;
import org.delta.people.Owner;
import org.delta.people.OwnerFactory;
import org.delta.people.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

public class App {
    public void run() {
        runBank();
    }

    void runBank() {
        // dependencies
        AccountNumberGenerator accountNumberGenerator = new BankAccountNumberGenerator();
        PersonIdValidator personIdValidator = new PersonIdValidator();
        AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
        TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
        MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);

        // factories
        OwnerFactory ownerFactory = new OwnerFactory(personIdValidator, accountNumberGenerator);
        BankAccountFactory bankAccountFactory = new BankAccountFactory(accountNumberGenerator);

        // DAOs
        Owner owner1 = ownerFactory.createOwner("John", "Doe", "1234567890");
        BankAccount basicBankAccount = bankAccountFactory.createBankAccount(1000, owner1);
        BankAccount studentBankAccount = bankAccountFactory.createStudentBankAccount(1000, owner1);

        // test
        accountDetailPrinter.printDetail(basicBankAccount);
        accountDetailPrinter.printDetail(studentBankAccount);
    }
}
