package org.delta.investment;

import com.google.inject.Inject;

import java.util.Date;

public class StockFactory {
    public Stock createStock(String symbol, double price) {
        return new Stock(symbol, price);
    }

    public Stock createDividendStock(String symbol, double price, float dividendYield, DividendFrequency dividendFrequency, Date lastDividendPaidAt) {
        return new Stock(symbol, price).withDividendProperties(dividendYield, dividendFrequency, lastDividendPaidAt);
    }
}
