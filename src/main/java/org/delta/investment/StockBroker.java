package org.delta.investment;

import com.google.inject.Inject;
import org.delta.accounts.MoneyTransferService;

public class StockBroker {
    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    MoneyTransferService moneyTransferService;

    public void buyStock(InvestmentAccount account, String stockSymbol, double quantity) {
        Stock stock = globalStockStorage.get(stockSymbol);

        if(stock == null) {
            throw new RuntimeException("Stock not found");
        }

        if(!moneyTransferService.hasSufficientFunds(account, quantity * globalStockStorage.get(stockSymbol).getPrice())) {
            throw new RuntimeException("Insufficient funds");
        }

        // Deduct the money from the account
        moneyTransferService.deductMoney(account, quantity * globalStockStorage.get(stockSymbol).getPrice());

        // Add the stock to the account
        account.addStock(stock, quantity);
    }

    public void sellStock(InvestmentAccount account, String stockSymbol, double quantity) {
        if(!account.hasSufficientStocks(stockSymbol, quantity)) {
            throw new RuntimeException("Insufficient stocks");
        }

        Stock stock = globalStockStorage.get(stockSymbol);

        if(stock == null) {
            throw new RuntimeException("Stock not found");
        }


        // add the money from the account
        moneyTransferService.addMoney(account, quantity * stock.getPrice());

        // Remove the stock from the account
        account.removeStock(stock, quantity);
    }
}
