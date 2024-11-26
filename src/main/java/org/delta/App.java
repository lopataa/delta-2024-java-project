package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.BankAccountFacade;
import org.delta.accounts.SavingsAccount;
import org.delta.accounts.interest.InterestingService;
import org.delta.cards.PaymentCard;
import org.delta.cards.PaymentCardFacade;
import org.delta.cards.PaymentCardFactory;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.investment.*;
import org.delta.people.Owner;
import org.delta.people.OwnerFactory;
import org.delta.people.OwnerJsonSerializationService;
import org.delta.print.AccountDetailPrinter;
import org.delta.serialization.BankSerializationService;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class App {
    public void run() {
        runBank();
    }

    @Inject
    OwnerFactory ownerFactory;

    @Inject
    BankAccountFacade bankAccountFacade;

    @Inject
    AccountDetailPrinter accountDetailPrinter;

    @Inject
    OwnerJsonSerializationService ownerJsonSerializationService;

    @Inject
    AtmService atmService;

    @Inject
    InterestingService interestingService;

    @Inject
    StockFacade stockFacade;

    @Inject
    StockBroker stockBroker;

    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    BankSerializationService bankSerializationService;

    void runBank() {
        Owner owner = ownerFactory.createOwner("John", "Doe", "11");

        stockFacade.createDividendStock("AAPL", 222.01, 0.0045f, DividendFrequency.QUARTERLY, new Date(2024, 8, 15));
        stockFacade.createStock("GOOG", 170.68);
        stockFacade.createDividendStock("O", 58.33, 0.051f, DividendFrequency.MONTHLY, new Date(2024, 10, 15));

        InvestmentAccount investmentAccount = bankAccountFacade.createInvestmentAccount(1000, owner, "1234");


        InvestmentPie investmentPie = new InvestmentPie();
        investmentPie.addStock(globalStockStorage.get("AAPL"), 0.5);
        investmentPie.addStock(globalStockStorage.get("O"), 0.25);
        investmentPie.addStock(globalStockStorage.get("GOOG"), 0.25);

        investmentAccount.setDefaultInvestmentPie(investmentPie);

        stockBroker.autoInvest(investmentAccount, investmentPie, 1000);

        accountDetailPrinter.printDetail(investmentAccount);


        // lets pretend we are in the future and google has gone up by 10%
        globalStockStorage.get("GOOG").setPrice(170.68 * 1.1);

        accountDetailPrinter.printDetail(investmentAccount); // see were rich now :)


        // save the globalaccountstorage
        bankSerializationService.serializeAndWriteToFile();
    }
}
