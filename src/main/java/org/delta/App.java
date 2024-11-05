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

    void runBank() {
        Owner owner = ownerFactory.createOwner("John", "Doe", "11");
        BankAccount bankAccount = bankAccountFacade.createBankAccount(1000, owner);

        atmService.deposit(bankAccount.getPaymentCards().getFirst(), 100);

        String cardNumber = bankAccount.getPaymentCards().getFirst().getNumber();
        atmService.withdraw(cardNumber, 50);

        accountDetailPrinter.printDetail(bankAccount);

        SavingsAccount savingsAccount = bankAccountFacade.createSavingBankAccount(1000, owner, "1234");

        // add interest
        this.interestingService.calculate();

        stockFacade.createDividendStock("AAPL", 222.01, 0.0045f, DividendFrequency.QUARTERLY, new Date(2024, 8, 15));
        stockFacade.createStock("GOOG", 170.68);
        stockFacade.createDividendStock("O", 58.33, 0.051f, DividendFrequency.MONTHLY, new Date(2024, 10, 15));

        InvestmentAccount investmentAccount = bankAccountFacade.createInvestmentAccount(1000, owner, "1234");

        globalStockStorage.get("AAPL");

        InvestmentPie investmentPie = new InvestmentPie();
        investmentPie.addStock(globalStockStorage.get("AAPL"), 0.5);
        investmentPie.addStock(globalStockStorage.get("O"), 0.25);
        investmentPie.addStock(globalStockStorage.get("GOOG"), 0.25);

        investmentAccount.setDefaultInvestmentPie(investmentPie);

        stockBroker.autoInvest(investmentAccount, investmentPie, 1000);

        accountDetailPrinter.printDetail(investmentAccount);
    }
}
