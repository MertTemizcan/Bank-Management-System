package bankAccountManagement;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Account {

    private final String id;
    private String name;
    private String surname;
    private double balance;
    private final String accountNumber;
    private final String iban;
    private final static SecureRandom random = new SecureRandom();
    private static final Set<String> usedIds = new HashSet<>();
    private static final Set<String> usedIbans = new HashSet<>();
    private static final Set<String> usedAccountNumbers = new HashSet<>();


    public Account(String name, String surname) {
        this.id = generateId();
        setName(name);
        setSurname(surname);
        this.balance = 0;
        this.accountNumber = generateAccountNumber();
        this.iban = generateIban();
    }

    private String generateId() {
        String id;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }

            id = sb.toString();
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }

    private String generateIban() {
        String iban;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("TR");

            for(int i = 0; i < 24; i++) {
                sb.append(random.nextInt(10));
            }

            iban = sb.toString();
        } while (usedIbans.contains(iban));
        usedIbans.add(iban);
        return iban;
    }

    private String generateAccountNumber() {
        String accountNumber;
        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }

            accountNumber = sb.toString();
        }  while (usedAccountNumbers.contains(accountNumber));
        usedAccountNumbers.add(accountNumber);
        return accountNumber;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ad boş bırakılamaz.");
        }
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public final void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Soyad boş bırakılamaz.");
        }
        this.surname = surname.trim();
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getIban() {
        return this.iban;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Çekilecek tutar sıfırdan büyük olmalıdır.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Yetersiz bakiye. Mevcut bakiye: " + balance);
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Yatırılacak tutar sıfırdan büyük olmalıdır.");
        }
        this.balance += amount;
    }

    public void transferTo(Account targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Hedef hesap geçersiz.");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    @Override
    public String toString() {
        return String.format("Ad: %s %s | Bakiye: %.2f TL | Hesap No: %s | IBAN: %s", name, surname, balance, accountNumber,iban);
    }
}