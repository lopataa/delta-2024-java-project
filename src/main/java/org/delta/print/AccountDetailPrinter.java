package org.delta.print;

import org.delta.accounts.BankAccount;
import org.delta.cards.PaymentCard;
import org.delta.investment.InvestmentAccount;
import org.delta.investment.Stock;
import org.delta.investment.StockOwnership;

public class AccountDetailPrinter {
    public void printDetail(BankAccount bankAccount) {
        // print this prettily
        System.out.println("===");

        System.out.print("Account owner: ");
        System.out.print(bankAccount.getOwner().getLastname());
        System.out.print(" ");
        System.out.println(bankAccount.getOwner().getFirstname());

        System.out.print("Account number: ");
        System.out.println(bankAccount.getAccountNumber());

        System.out.print("Balance: ");
        System.out.println(bankAccount.getBalance());

        System.out.println();

        if(!bankAccount.getPaymentCards().isEmpty()) {
            System.out.println("Associated payment cards: ");

            for(PaymentCard paymentCard : bankAccount.getPaymentCards()) {
                String censoredAccountNumber = "****" + paymentCard.getNumber().substring(12, 16) + " (PIN: " + paymentCard.getPersonalIdentificationNumber() + ")";
                System.out.println(censoredAccountNumber);
            }
        }

        if(bankAccount instanceof InvestmentAccount investmentAccount) {
            System.out.println("Owned stocks: ");
            for(String stockSymbol : investmentAccount.getOwnedStocks().keySet()) {
                StockOwnership stockOwnership = investmentAccount.getOwnedStocks().get(stockSymbol);
                Stock stock = stockOwnership.getStock();
                System.out.print(stockSymbol);
                System.out.print(": ");
                System.out.print(stockOwnership.getQuantity());
                System.out.print("; value: ");
                System.out.println(stock.getPrice() * stockOwnership.getQuantity());
            }
            System.out.println();
            System.out.print("Total stocks value: ");
            double totalStockValue = investmentAccount.getOwnedStocks().values().stream().mapToDouble(stockOwnership -> stockOwnership.getStock().getPrice() * stockOwnership.getQuantity()).sum();
            System.out.println(totalStockValue);
        }

        System.out.println("===");
    }
}
