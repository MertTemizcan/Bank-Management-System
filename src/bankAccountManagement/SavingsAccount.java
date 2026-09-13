package bankAccountManagement;

public class SavingsAccount extends Account {

    private double bonusPoint;

    public SavingsAccount(String id, String name, String surname, double balance, String accountNumber, double bonusPoint) {
        super(id, name, surname, balance, accountNumber);
        setBonusPoint(bonusPoint);
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    public final void setBonusPoint(double bonusPoint) {
        if (bonusPoint < 0) {
            throw new IllegalArgumentException("Bonus puan değeri sıfırdan küçük olamaz.");
        }
        this.bonusPoint = bonusPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Bonus Puan: %.2f", bonusPoint);
    }
}