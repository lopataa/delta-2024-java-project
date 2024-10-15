package org.delta.print;

import org.delta.accounts.BankAccount;
import org.delta.accounts.PaymentCard;

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

        System.out.println("===");
    }
}
