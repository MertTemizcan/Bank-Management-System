# Bank-Management-System
Bu proje; Nesne Yönelimli Programlama (OOP) prensiplerini gerçekçi bir senaryo üzerinde uygulamak ve Java dilindeki derinliğini pekiştirmek amacıyla geliştirilmiştir. Temel bir banka yönetim sistemini simüle eden uygulama, kullanıcıların hesap açma, para transferi ve bakiye yönetimi gibi işlemleri güvenli bir mimari üzerinden gerçekleştirmesini sağlar.

🚀 Proje Özellikleri
Dinamik Menü Sistemi: Kullanıcıların çıkış yapana kadar işlem seçebildiği while döngüsü ve switch-case tabanlı etkileşimli konsol arayüzü.

Gelişmiş Hesap Yönetimi: Standart hesaplar ve bonus puan kazandıran birikim hesapları (SavingsAccount) için ayrı işleme mantığı.

Bakiye Güvenliği: Negatif bakiye atamasını ve yetersiz bakiye ile işlem yapılmasını engelleyen kontrol mekanizmaları.

🛠 Teknik Mimari ve OOP Yaklaşımı
Bu projede yazılımın sürdürülebilirliği ve güvenliği için şu temel prensipler uygulanmıştır:

Encapsulation (Kapsülleme): Tüm kritik veriler (ad, soyad, bakiye, hesap numarası) private olarak tanımlanmıştır. Verilere erişim ve veri manipülasyonu kontrollü Getter ve Setter metotları üzerinden sağlanarak veri bütünlüğü korunmuştur.

Inheritance (Kalıtım): SavingsAccount sınıfı, Account ana sınıfından türetilmiştir. Bu sayede temel bankacılık fonksiyonları (sendMoney, withdrawMoney) tekrar yazılmadan miras alınmış, kodun tekrar edilebilirliği (DRY) artırılmıştır.

Method Overriding (Metot Ezme): Ana sınıfta bulunan showInfos metodu, SavingsAccount sınıfında @Override edilerek bu hesap türüne özgü olan "Bonus Puan" bilgisini de gösterecek şekilde özelleştirilmiştir.

Constructor Overloading: Farklı parametre setleriyle hesap oluşturulmasına imkan tanıyan esnek yapıcı metotlar kullanılmıştır.

💻 Kullanılan Teknolojiler
Dil: Java

IDE: Eclipse 

📂 Kurulum ve Çalıştırma
Bu repoyu bilgisayarınıza clone'layın: git clone [https://github.com/MertTemizcan/Bank-Management-System](https://github.com/MertTemizcan/Bank-Management-System)

Eclipse veya herhangi bir Java IDE'si ile projeyi açın.

Main.java dosyasını sağ tıklayıp "Run As > Java Application" seçeneğiyle çalıştırın.
