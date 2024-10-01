package org.delta;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.factories.BankAccountFactory;
import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.services.BankAccountNumberGenerator;
import org.delta.accounts.services.MoneyTransferService;
import org.delta.accounts.services.TransferFeeCalculator;
import org.delta.people.OwnerFactory;
import org.delta.people.PersonIdValidator;
import org.delta.print.AccountDetailPrinter;

@Singleton
public class DIContainer {
    private AccountNumberGenerator accountNumberGenerator = new BankAccountNumberGenerator();
    private PersonIdValidator personIdValidator = new PersonIdValidator();
    private AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);

    public Gson getGson() {
        return gson;
    }

    private Gson gson = new Gson();

    private OwnerFactory ownerFactory = new OwnerFactory(personIdValidator, accountNumberGenerator);
    @Inject
    private BankAccountFactory bankAccountFactory;

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
