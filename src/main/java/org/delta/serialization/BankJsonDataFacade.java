package org.delta.serialization;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.GlobalAccountStorage;
import org.delta.cards.GlobalCardStorage;
import org.delta.investment.GlobalStockStorage;

@Singleton
public class BankJsonDataFacade {
    @Inject
    private GlobalAccountStorage globalBankAccountStorage;

    @Inject
    private GlobalStockStorage globalStockStorage;

    @Inject
    private GlobalCardStorage globalCardStorage;

    public BankJsonData createBankJsonDataFromGlobalStorages() {
        BankJsonData data = new BankJsonData();
        data.accounts = globalBankAccountStorage.bankAccounts.values().stream().toList();
        data.stocks = globalStockStorage.stocks.values().stream().toList();
        data.paymentCards = globalCardStorage.paymentCards.values().stream().toList();

        return data;
    }
}
