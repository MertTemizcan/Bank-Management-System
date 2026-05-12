package bankAccountManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        SavingsAccount savingAccount1 = new SavingsAccount("Mert", "Temizcan", 4000.0, "TR196847", 100.0);
        
        boolean running = true;

        while (running) {
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");
            System.out.println("1. Hesap bilgilerini göster");
            System.out.println("2. Para gönder");
            System.out.println("3. Para çek");
            System.out.println("4. Bonus Puanımı Sorgula");
            System.out.println("0. Çıkış");
            System.out.print("\nSeçiminiz: ");
            
            int choice = scanner.nextInt();
            System.out.println(); 

            switch (choice) {
                case 1:
                    savingAccount1.showInfos();
                    System.out.println();
                    break;
                case 2:
                    savingAccount1.sendMoney();
                    System.out.println();
                    break;
                case 3:
                    savingAccount1.withdrawMoney();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Mevcut bonus puanınız: " + savingAccount1.getBonusPoint());
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Sistemden çıkış yapıldı sağlıklı günler dileriz");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız lütfen tekrar deneyin");
            }
        }
        
        scanner.close();
    }
}