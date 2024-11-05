package org.delta.accounts.interest;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalAccountStorage;
import org.delta.accounts.MoneyTransferService;
import org.delta.accounts.SavingsAccount;

public class InterestingService {
    @Inject
    private GlobalAccountStorage globalAccountStorage;

    @Inject
    private InterestCalculator interestCalculator;

    @Inject
    private MoneyTransferService moneyTransferService;

    private long interestInterval = 2592000000L;

    public void calculate() {
        for (BankAccount account : this.globalAccountStorage.bankAccounts.values()) {
            if (account instanceof SavingsAccount savingsAccount) {
                if (System.currentTimeMillis() - this.interestInterval > savingsAccount.getLastInterestedAt()) {
                    this.moneyTransferService.addMoney(account, this.interestCalculator.calculateInterest(savingsAccount));
                    savingsAccount.setLastInterestedAt(System.currentTimeMillis());
                }
            }
        }
    }
}
