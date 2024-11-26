package org.delta.serialization;

import org.delta.accounts.BankAccount;
import org.delta.cards.PaymentCard;
import org.delta.investment.InvestmentPie;
import org.delta.investment.Stock;

import java.util.List;

public class BankJsonData {
    public List<PaymentCard> paymentCards;
    public List<BankAccount> accounts;
    public List<Stock> stocks;
    public List<InvestmentPie> investmentPies;
}
