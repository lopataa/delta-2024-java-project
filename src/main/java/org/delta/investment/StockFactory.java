package org.delta.investment;

import com.google.inject.Inject;

import java.util.Date;

public class StockFactory {
    @Inject
    GlobalStockStorage globalStockStorage;

    public Stock createStock(String symbol, double price) {
        Stock stock = new Stock(symbol, price);
        globalStockStorage.put(stock);
        return stock;
    }

    public Stock createDividendStock(String symbol, double price, float dividendYield, DividendFrequency dividendFrequency, Date lastDividendPaidAt) {
        Stock stock = new Stock(symbol, price).withDividendProperties(dividendYield, dividendFrequency, lastDividendPaidAt);
        globalStockStorage.put(stock);
        return stock;
    }
}
