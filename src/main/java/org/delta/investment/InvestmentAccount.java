package org.delta.investment;

import org.delta.accounts.BankAccount;
import org.delta.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class InvestmentAccount extends BankAccount {
    private HashMap<String, StockOwnership> ownedStocks = new HashMap<String, StockOwnership>();

    private InvestmentPie defaultInvestmentPie = new InvestmentPie();

    public InvestmentPie getDefaultInvestmentPie() {
        return defaultInvestmentPie;
    }

    public void setDefaultInvestmentPie(InvestmentPie defaultInvestmentPie) {
        this.defaultInvestmentPie = defaultInvestmentPie;
    }

    public InvestmentAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }

    public void addStock(Stock stock, double quantity) {
        // if has any of the existing stocks already just add the amount || or add the new stock pls mate do it im lazy
        if(this.ownedStocks.containsKey(stock.getSymbol())) {
            this.ownedStocks.get(stock.getSymbol()).addQuantity(quantity);
        } else {
            this.ownedStocks.put(stock.getSymbol(), new StockOwnership(stock, quantity));
        }
    }

    public void removeStock(Stock stock, double quantity) {
        this.addStock(stock, -quantity);
    }

    public boolean hasStock(String stockSymbol) {
        return this.ownedStocks.containsKey(stockSymbol);
    }

    public boolean hasSufficientStocks(String stockSymbol, double quantity) {
        if(!this.ownedStocks.containsKey(stockSymbol)) {
            return false;
        }

        return this.ownedStocks.get(stockSymbol).getQuantity() >= quantity;
    }

    public double getStockQuantity(String stockSymbol) {
        if(!this.ownedStocks.containsKey(stockSymbol)) {
            return 0;
        }

        return this.ownedStocks.get(stockSymbol).getQuantity();
    }

    public HashMap<String, StockOwnership> getOwnedStocks() {
        return ownedStocks;
    }

    public double getAssetsValue() {
        double value = 0;
        for(Map.Entry<String, StockOwnership> entry : this.ownedStocks.entrySet()) {
            StockOwnership stockOwnership = entry.getValue();
            value += stockOwnership.getStock().getPrice() * stockOwnership.getQuantity();
        }

        return value;
    }
}
