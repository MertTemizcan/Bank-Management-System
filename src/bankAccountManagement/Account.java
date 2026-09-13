package bankAccountManagement;

public class Account {

    private final String id;
    private String name;
    private String surname;
    private double balance;
    private final String accountNumber;

    public Account(String id, String name, String surname, double balance, String accountNumber) {
        this.id = validateId(id);
        setName(name);
        setSurname(surname);
        setBalance(balance);
        this.accountNumber = accountNumber;
    }

    public String validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID boş bırakılamaz");
        }

        return id.trim();
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
        return balance;
    }

    public final void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Bakiye negatif olamaz.");
        }
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
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
        return String.format("Ad: %s %s | Bakiye: %.2f TL | Hesap No: %s", name, surname, balance, accountNumber);
    }
}