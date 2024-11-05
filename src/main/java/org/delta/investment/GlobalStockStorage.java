package org.delta.investment;

import com.google.inject.Singleton;

import java.util.HashMap;

@Singleton
public class GlobalStockStorage {
    public HashMap<String, Stock> stocks = new HashMap<String, Stock>();

    public void put(Stock stock) {
        this.stocks.put(stock.getSymbol(), stock);
    }

    public Stock get(String symbol) {
        return this.stocks.get(symbol);
    }
}
