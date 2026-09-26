package bankAccountManagement;

import java.math.BigDecimal;

public class Account {

    private final String id;
    private String name;
    private String surname;
    private BigDecimal balance;
    private final String accountNumber;
    private final String iban;


    public Account(String name, String surname) {
        this.id = NumberGenerator.generateId();
        setName(name);
        setSurname(surname);
        this.balance = BigDecimal.ZERO;
        this.accountNumber = NumberGenerator.generateAccountNumber();
        this.iban = NumberGenerator.generateIban();
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

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getIban() {
        return this.iban;
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Çekilecek tutar sıfırdan büyük olmalıdır.");
        }
        if (amount.compareTo(this.balance) > 0) {
            throw new IllegalStateException("Yetersiz bakiye. Mevcut bakiye: " + this.balance);
        }
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Yatırılacak tutar sıfırdan büyük olmalıdır.");
        }
        this.balance = this.balance.add(amount);
    }

    public void transferTo(Account targetAccount, BigDecimal amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Hedef hesap geçersiz.");
        }
        if (this == targetAccount || this.id.equals(targetAccount.getId())) {
            throw new IllegalArgumentException("Kendi hesabınıza transfer yapamazsınız.");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    @Override
    public String toString() {
        return String.format("Ad: %s %s | Bakiye: %s TL | Hesap No: %s | IBAN: %s", name, surname, balance, accountNumber,iban);
    }
}