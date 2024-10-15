package org.delta.accounts;

import java.math.BigInteger;

public class IBANValidator {
    public boolean isIBANValid(String IBAN) {
        if (IBAN == null || IBAN.length() < 15 || IBAN.length() > 34) {
            return false;
        }

        // Move the first four characters to the end of the string
        String rearrangedIBAN = IBAN.substring(4) + IBAN.substring(0, 4);

        // Replace each letter in the string with two digits
        StringBuilder numericIBAN = new StringBuilder();
        for (char ch : rearrangedIBAN.toCharArray()) {
            if (Character.isDigit(ch)) {
                numericIBAN.append(ch);
            } else if (Character.isLetter(ch)) {
                numericIBAN.append(Character.getNumericValue(ch));
            } else {
                return false;
            }
        }

        // Convert the string to a BigInteger and perform a modulo 97 operation
        BigInteger ibanNumber = new BigInteger(numericIBAN.toString());
        return ibanNumber.mod(BigInteger.valueOf(97)).intValue() == 1;
    }
}