package org.delta.people;

import org.delta.accounts.interfaces.AccountNumberGenerator;
import org.delta.accounts.services.BankAccountNumberGenerator;

public class OwnerFactory {
    private PersonIdValidator personIdValidator;

    private AccountNumberGenerator accountNumberGenerator;

    public OwnerFactory(PersonIdValidator personIdValidator, AccountNumberGenerator accountNumberGenerator) {
        this.personIdValidator = personIdValidator;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public Owner createOwner(String name, String surname, String id) {
        if(!this.personIdValidator.isPersonIdValid(id)) {
            throw new IllegalArgumentException("Invalid Id \uD83D\uDE2D");
        }

        return new Owner(name, surname, id);
    }

}
