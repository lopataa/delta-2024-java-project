package org.delta.serialization;

import org.delta.accounts.BankAccount;
import org.delta.cards.PaymentCard;
import org.delta.investment.InvestmentPie;
import org.delta.investment.Stock;

import java.util.HashMap;
import java.util.List;

public class BankJsonData {
    public HashMap<String, PaymentCard> paymentCards;
    public HashMap<String, BankAccount> accounts;
    public HashMap<String, Stock> stocks;
    public HashMap<String, InvestmentPie> investmentPies;
}
