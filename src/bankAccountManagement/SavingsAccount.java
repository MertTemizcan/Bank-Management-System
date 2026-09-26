package bankAccountManagement;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    private double bonusPoint;

    public SavingsAccount(String name, String surname) {
        super(name, surname);
        this.bonusPoint = 100.0;
    }

    @Override
    public void deposit(BigDecimal amount) {
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