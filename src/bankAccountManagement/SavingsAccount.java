package bankAccountManagement;

public class SavingsAccount extends Account{
	
	private double bonusPoint;
	
	public SavingsAccount(String name, String surname, double balance, String accountNumber, double bonusPoint) {
		super(name, surname, balance, accountNumber);
		this.bonusPoint = bonusPoint;
	}
	
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	
	public void setBonusPoint(double bonusPoint) {
		if(bonusPoint >= 0) {
			this.bonusPoint = bonusPoint;
		} else {
			System.out.println("Bonus puan değeri sıfırdan küçük olamaz");
		}
	}
	
	@Override
	public void showInfos() {
		super.showInfos();
		System.out.println("Kalan bonus puanınız:" + bonusPoint);
	}

}
