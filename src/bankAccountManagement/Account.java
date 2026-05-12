package bankAccountManagement;

import java.util.Scanner;

public class Account {
	
	private String name;
	private String surname;
	private double balance;
	private String accountNumber;
	
	Scanner scan = new Scanner(System.in);
	
	public Account(String name, String surname, double balance, String accountNumber) {
		this.name = name;
		this.surname = surname;
		this.setBalance(balance);
		this.accountNumber = accountNumber;
	}
	
	public Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.balance = 0;
		this.accountNumber = "Bilgi yok";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		} else {
			System.out.println("Bakiye 0'dan küçük olamaz");
		}
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void sendMoney() {
		System.out.print("Kime para göndermek istiyorsunuz:");
		String name = scan.nextLine();
		System.out.print("Ne kadar para göndermek istiyorsunuz:");
		double money = scan.nextDouble();
		scan.nextLine();
		if(balance >= money) {
			balance -= money;
			System.out.println(name + " kişisine " + money + " tl para gönderildi kalan bakiyeniz:" + balance);
		} else {
			System.out.println("Hesabınızda göndermek istediğiniz miktar kadar paranız olmadığı için işleminizi gerçekleştiremiyoruz");
			return;
		}
	}
	
	public void withdrawMoney() {
		System.out.print("Ne kadar para çekmek istiyorsunuz:");
		double withdrawMoney = scan.nextDouble();
		if(balance >= withdrawMoney) {
			balance -= withdrawMoney;
			System.out.println(withdrawMoney + " tl para çekme işleminiz başarıyla tamamlanmıştır kalan bakiyeniz:" + balance);
		} else {
			System.out.println("Hesabınızda çekmek istediğiniz miktar kadar paranız olmadığı için işleminizi gerçekleştiremiyoruz");
			return;
		}
	}
	
	public void showInfos() {
		System.out.println("Adınız:" + getName());
		System.out.println("Soyadınız:" + getSurname());
		System.out.println("Kalan bakiyeniz:" + getBalance());
		System.out.println("Hesap numaranız:" + getAccountNumber());
	}
	
	

}
