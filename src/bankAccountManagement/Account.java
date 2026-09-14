package bankAccountManagement;
import java.util.Random;

public class Account {

    private final String id;
    private String name;
    private String surname;
    private double balance;
    private final String accountNumber;
    private final String iban;

    public Account(String id, String name, String surname) {
        this.id = validateId(id);
        setName(name);
        setSurname(surname);
        this.balance = 0;
        this.accountNumber = generateAccountNumber();
        this.iban = generateIban();
    }

    private String validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID boş bırakılamaz");
        }

        return id.trim();
    }

    private String generateIban() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("TR");
        for(int i = 0; i < 24; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
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