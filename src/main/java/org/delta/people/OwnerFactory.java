package org.delta.people;

public class OwnerFactory {
    private PersonIdValidator personIdValidator;

    public OwnerFactory() {
        this.personIdValidator = new PersonIdValidator();
    }

    public Owner createOwner(String name, String surname, String id) {
        return new Owner(name, surname, id);
    }
}
