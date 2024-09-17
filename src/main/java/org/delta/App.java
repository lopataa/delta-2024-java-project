package org.delta;

import org.delta.accounts.BankAccount;
import org.delta.accounts.MoneyTransferService;
import org.delta.people.Owner;

public class App {
    public void run() {
        runBank();
    }

    void runBank() {
        Owner owner = new Owner("Patwik", "Zlý");
        BankAccount bankAccount = new BankAccount(0, owner, "CZ001234561234567890");
        MoneyTransferService moneyTransferService = new MoneyTransferService();

        moneyTransferService.depositMoney(bankAccount, 500);

        boolean isInDebt = bankAccount.getBalance() < 0;
        if(isInDebt) {
            System.out.printf("this guy %s is in debt", bankAccount.getOwner().getFirstname());
        }
    }
}
