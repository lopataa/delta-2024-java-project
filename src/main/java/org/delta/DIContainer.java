package org.delta;

import org.delta.accounts.factories.BankAccountFactory;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.accounts.services.MoneyTransferService;
import org.delta.accounts.services.TransferFeeCalculator;
import org.delta.people.OwnerFactory;
import org.delta.people.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

public class DIContainer {
    private AccountNumberGenerator accountNumberGenerator = new BankAccountNumberGenerator();
    private PersonIdValidator personIdValidator = new PersonIdValidator();
    private AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);

    private OwnerFactory ownerFactory = new OwnerFactory(personIdValidator, accountNumberGenerator);
    private BankAccountFactory bankAccountFactory = new BankAccountFactory(accountNumberGenerator);

    public AccountNumberGenerator getAccountNumberGenerator() {
        return accountNumberGenerator;
    }

    public PersonIdValidator getPersonIdValidator() {
        return personIdValidator;
    }

    public AccountDetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }
}
