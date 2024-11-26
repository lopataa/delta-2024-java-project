package org.delta.accounts;

import org.delta.people.Owner;

public class StudentBankAccount extends BankAccount {

    private String studentStudiesConfirmationExpiresAt = null;

    public StudentBankAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }

    public StudentBankAccount(double balance, Owner owner, String accountNumber, String studentStudiesConfirmationExpiresAt) {
        super(balance, owner, accountNumber);

        this.studentStudiesConfirmationExpiresAt = studentStudiesConfirmationExpiresAt;
    }

    public String getStudentStudiesConfirmationExpiresAt() {
        return studentStudiesConfirmationExpiresAt;
    }

    public void setStudentStudiesConfirmationExpiresAt(String studentStudiesConfirmationExpiresAt) {
        this.studentStudiesConfirmationExpiresAt = studentStudiesConfirmationExpiresAt;
    }
}
