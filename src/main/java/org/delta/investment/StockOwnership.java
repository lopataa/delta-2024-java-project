package org.delta.investment;

public class StockOwnership {
    private Stock stock;
    private double quantity;

    public StockOwnership(Stock stock, double quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public double getQuantity() {
        return quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(double quantity) {
        this.quantity -= quantity;
    }
}
