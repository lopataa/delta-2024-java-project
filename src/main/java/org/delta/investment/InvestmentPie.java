package org.delta.investment;

import org.delta.lib.Pair;

import java.util.ArrayList;

public class InvestmentPie {
    public ArrayList<Pair<Double, Stock>> stocks = new ArrayList<Pair<Double, Stock>>();

    public void addStock(Stock stock, double percentage) {
        stocks.add(new Pair<>(percentage, stock));
    }
}
