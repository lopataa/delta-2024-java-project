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

    @Inject BankJsonDataFactory bankJsonDataFactory;

    public BankJsonData createBankJsonDataFromGlobalStorages() {
        BankJsonData data = bankJsonDataFactory.create();
        data.accounts = globalBankAccountStorage.bankAccounts;
        data.stocks = globalStockStorage.stocks;
        data.paymentCards = globalCardStorage.paymentCards;

        return data;
    }

    public void updateGlobalStoragesFromBankJsonData(BankJsonData bankJsonData) {
        globalBankAccountStorage.bankAccounts = bankJsonData.accounts;
        globalStockStorage.stocks = bankJsonData.stocks;
        globalCardStorage.paymentCards = bankJsonData.paymentCards;
    }
}
