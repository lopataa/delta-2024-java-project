package org.delta.investment;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalAccountStorage;
import org.delta.accounts.MoneyTransferService;

import java.util.Date;

public class DividendPayoutService {
    @Inject
    GlobalAccountStorage globalAccountStorage;

    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    MoneyTransferService moneyTransferService;

    @Inject
    DividendCalculator dividendCalculator;

    public void run() {
        // go through all stocks
        for (Stock stock : globalStockStorage.stocks.values()) {
            // go through all accounts
            for (BankAccount account : globalAccountStorage.bankAccounts.values()) {
                // if the account has the stock
                if (account instanceof InvestmentAccount investmentAccount) {

                    if (!investmentAccount.hasStock(stock.getSymbol())) {
                        continue;
                    }

                    if (stock.isDividendStock() && stock.isDividendDue(new Date())) {
                        double dividend = dividendCalculator.calculateDividend(stock, investmentAccount.getStockQuantity(stock.getSymbol()));

                        // add the dividend to the account
                        moneyTransferService.addMoney(account, dividend);
                    }
                }
            }

            // set the last dividend payout time
            stock.setLastDividendPaidAt(new Date());
        }
    }
}
