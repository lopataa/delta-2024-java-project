package org.delta;

import org.delta.accounts.BankAccount;
import org.delta.accounts.factories.BankAccountFactory;
import org.delta.accounts.services.MoneyTransferService;
import org.delta.people.Owner;
import org.delta.people.OwnerFactory;
import org.delta.print.AccountDetailPrinter;

public class App {
    public void run() {
        runBank();
    }

    void runBank() {
        OwnerFactory ownerFactory = new OwnerFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        Owner owner1 = ownerFactory.createOwner("John", "Doe", "1234567890");
        BankAccount basicBankAccount = bankAccountFactory.createBankAccount(1000, owner1);
        BankAccount studentBankAccount = bankAccountFactory.createStudentBankAccount(1000, owner1);

        new AccountDetailPrinter().printDetail(basicBankAccount);
        new AccountDetailPrinter().printDetail(studentBankAccount);
    }
}
