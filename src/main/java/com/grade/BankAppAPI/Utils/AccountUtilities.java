package com.grade.BankAppAPI.Utils;

import java.security.SecureRandom;

public class AccountUtilities {

    public static final String AccountExistsCode = "001";
    public static final String AccountExistMessage = "This user is in our Database, Please Login!";

    public static final String AccountCreatedCode = "002";
    public static final String AccountCreatedMessage = "Account has been created!";

    // Generuje náhodné číslo účtu s definovanou dĺžkou, ktoré prejde Luhnovým algoritmom
    public static String generateValidAccountNumber(int length) {
        String accountNumber;
        do {
            accountNumber = generateAccountNumber(length);
        } while (!isValidAccountNumber(accountNumber));

        return accountNumber;
    }

    // Generuje náhodné číslo účtu
    private static String generateAccountNumber(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder accountNumber = new StringBuilder();

        // Pridanie prvej číslice (nemôže byť 0)
        accountNumber.append(random.nextInt(9) + 1);

        // Generovanie zvyšných číslic
        for (int i = 1; i < length; i++) {
            accountNumber.append(random.nextInt(10));  // Náhodné číslo od 0 do 9
        }

        return accountNumber.toString();
    }

    // Overenie platnosti čísla účtu pomocou Luhnovho algoritmu
    public static boolean isValidAccountNumber(String accountNumber) {
        int sum = 0;
        boolean alternate = false;

        // Prejdeme cez číslo účtu odzadu
        for (int i = accountNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(accountNumber.substring(i, i + 1));

            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = n % 10 + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        // Platnosť závisí na tom, či súčet je deliteľný 10
        return (sum % 10 == 0);
    }
}
