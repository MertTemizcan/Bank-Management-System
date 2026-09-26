package bankAccountManagement;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount account = new SavingsAccount("Mert", "Temizcan");
        SavingsAccount targetAccount = new SavingsAccount("Ramazan", "Demir");

        account.deposit(new BigDecimal("4000"));
        targetAccount.deposit(new BigDecimal("3000"));

        boolean running = true;

        while (running) {
            System.out.println("\n--- İŞLEM MENÜSÜ ---");
            System.out.println("1. Hesap Bilgilerini Göster");
            System.out.println("2. Para Çek");
            System.out.println("3. Para Yatır");
            System.out.println("4. Bonus Puanını Sorgula");
            System.out.println("5. Para Transferi Yap");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.println(account);
                        break;
                    case 2:
                        System.out.print("Çekmek istediğiniz tutar: ");
                        BigDecimal withdrawAmount = scanner.nextBigDecimal();
                        account.withdraw(withdrawAmount);
                        System.out.printf("İşlem başarılı. Yeni bakiye: %.2f TL%n", account.getBalance());
                        break;
                    case 3:
                        System.out.print("Yatırmak istediğiniz tutar: ");
                        BigDecimal depositAmount = scanner.nextBigDecimal();
                        account.deposit(depositAmount);
                        System.out.printf("İşlem başarılı. Yeni bakiye: %.2f TL%n", account.getBalance());
                        break;
                    case 4:
                        System.out.printf("Mevcut bonus puanınız: %.2f%n", account.getBonusPoint());
                        break;
                    case 5:
                        System.out.println("Transfer etmek istediğiniz tutarı giriniz: ");
                        BigDecimal transferAmount = scanner.nextBigDecimal();
                        account.transferTo(targetAccount, transferAmount);
                        System.out.printf("%s kişisine %.2f TL gönderildi. Güncel bakiyeniz: %.2f TL%n", targetAccount.getName(), transferAmount, account.getBalance());
                        break;
                    case 0:
                        System.out.println("Çıkış yapıldı.");
                        running = false;
                        break;
                    default:
                        System.out.println("Geçersiz seçim.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }

        scanner.close();
    }
}