package org.delta.investment;

import static org.delta.investment.DividendFrequency.*;

public class DividendCalculator {
    public double calculateDividend(Stock stock, double quantity) {
        // take the frequency into account
        switch(stock.getDividendFrequency()) {
            case QUARTERLY:
                return stock.getDividendYield() * quantity / 4;
            case MONTHLY:
                return stock.getDividendYield() * quantity / 12;
            case BIANNUALLY:
                return stock.getDividendYield() * quantity / 2;
            case ANNUALLY:
                return stock.getDividendYield() * quantity;
            default:
                throw new RuntimeException("Unknown dividend frequency");
        }
    }
}
