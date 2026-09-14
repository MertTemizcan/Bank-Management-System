package bankAccountManagement;

public class SavingsAccount extends Account {

    private double bonusPoint;

    public SavingsAccount(String id, String name, String surname) {
        super(id, name, surname);
        this.bonusPoint = 100.0;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        this.bonusPoint = getBonusPoint() + 5.0;
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Bonus Puan: %.2f", bonusPoint);
    }
}