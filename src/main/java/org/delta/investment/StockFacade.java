package org.delta.investment;

import com.google.inject.Inject;

import java.util.Date;

public class StockFacade {
    @Inject
    GlobalStockStorage globalStockStorage;

    @Inject
    StockFactory stockFactory;

    public Stock createStock(String symbol, double price) {
        Stock stock = stockFactory.createStock(symbol, price);
        globalStockStorage.put(stock);

        return stock;
    }

    public Stock createDividendStock(String symbol, double price, float dividendYield, DividendFrequency dividendFrequency, Date lastDividendPaidAt) {
        Stock stock = stockFactory.createDividendStock(symbol, price, dividendYield, dividendFrequency, lastDividendPaidAt);
        globalStockStorage.put(stock);

        return stock;
    }
}
