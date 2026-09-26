package bankAccountManagement;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private NumberGenerator() {
    }


    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> usedIds = new HashSet<>();
    private static final Set<String> usedIbans = new HashSet<>();
    private static final Set<String> usedAccountNumbers = new HashSet<>();

    private static String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public static String generateId() {
        String id;
        do {
            id = generateRandomDigits(11);
        } while (!usedIds.add(id));

        return id;
    }

    public static String generateIban() {
        String iban;
        do {
            iban = "TR" + generateRandomDigits(24);
        } while (!usedIbans.add(iban));

        return iban;
    }

    public static String generateAccountNumber() {
        String accountNumber;
        do {
            accountNumber = generateRandomDigits(11);
        } while (!usedAccountNumbers.add(accountNumber));

        return accountNumber;
    }
}
