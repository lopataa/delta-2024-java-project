package org.delta.investment;

import java.text.DateFormat;
import java.util.Date;

public class Stock {
    private String symbol;
    private double price;


    private Double dividendYield; // THIS IS YEARLY DONT FORGET M8
    private DividendFrequency dividendFrequency;
    private Date lastDividendPaidAt;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public Stock withDividendProperties(double dividendYield, DividendFrequency dividendFrequency, Date lastDividendPaidAt) {
        this.dividendYield = dividendYield;
        this.dividendFrequency = dividendFrequency;
        this.lastDividendPaidAt = lastDividendPaidAt;

        return this;
    }

    public boolean isDividendDue(Date date) {
        // take the frequency into account
        Date dueDate = lastDividendPaidAt;

        switch (dividendFrequency) {
            case QUARTERLY:
                dueDate.setMonth(dueDate.getMonth() + 3);
                break;
            case MONTHLY:
                dueDate.setMonth(dueDate.getMonth() + 1);
                break;
            case BIANNUALLY:
                dueDate.setMonth(dueDate.getMonth() + 6);
                break;
            case ANNUALLY:
                dueDate.setYear(dueDate.getYear() + 1);
                break;
            default:
                throw new RuntimeException("Unknown dividend frequency");
        }

        return dueDate.before(date);
    }

    public boolean isDividendStock() {
        return dividendYield != null;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DividendFrequency getDividendFrequency() {
        return dividendFrequency;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public void setLastDividendPaidAt(Date lastDividendPaidAt) {
        this.lastDividendPaidAt = lastDividendPaidAt;
    }
}
