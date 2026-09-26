# Bank Management System

Bu proje; Nesne Yönelimli Programlama (OOP) ve Temiz Kod (Clean Code) prensiplerini gerçekçi bir bankacılık senaryosu üzerinde uygulamak amacıyla geliştirilmiş bir simülasyon sistemidir. 

Uygulama; finansal hassasiyet gerektiren veri tipleri, sorumlulukların ayrıştırılması (SRP), kod tekrarının önlenmesi (DRY) ve savunmacı programlama (defensive programming) yaklaşımları dikkate alınarak tasarlanmıştır.

---

## 🚀 Öne Çıkan Özellikler

* **Finansal Hassasiyet:** Finansal hesaplamalarda ve bakiye yönetiminde kayan noktalı sayı (`double`/`float`) hatalarını engellemek adına endüstri standardı olan `BigDecimal` veri yapısı kullanılmıştır.
* **Benzersiz Numara Üretimi:** Kriptografik olarak güvenli rastgele sayı üretimi (`SecureRandom`) ve `Set` veri yapısıyla çakışmasız 11 haneli Müşteri No, Hesap No ve TR formatında IBAN üretimi sağlanır.
* **Farklılaştırılmış Hesap Modelleri:** Temel hesap operasyonlarının yanı sıra para yatırma işlemlerinde bonus puan kazandıran Birikim Hesabı (`SavingsAccount`) kurgusu mevcuttur.
* **Güvenli İşlem Doğrulaması:**
  * Sıfır ve negatif tutarlı işlem girişimlerinin engellenmesi.
  * Yetersiz bakiye durumlarında işlemin durdurulması.
  * Geçersiz (`null`) veya kullanıcının kendi hesabına transfer yapma girişimlerinin engellenmesi.
* **İnteraktif Konsol Arayüzü:** `Scanner` akışı üzerinden çalışan menü yönetimi ve işlem geri bildirimleri.

---

## 🛠️ Teknik Mimari ve Tasarım Prensipleri

* **Encapsulation (Kapsülleme):** Hesap kimlikleri, bakiye ve kullanıcı bilgileri `private` olarak sınırlandırılmış; iş kuralları ve veri manipülasyonu kontrollü metotlar (`withdraw`, `deposit`, `setName` vb.) üzerinden sağlanmıştır.
* **Inheritance & Polymorphism:** `SavingsAccount` sınıfı, `Account` üst sınıfını genişleterek temel işlevleri devralmış; `deposit` ve `toString` metotlarını `@Override` ederek kendi iş mantığını (bonus puan mekanizması) işletmiştir.
* **Single Responsibility (Tek Sorumluluk):** Benzersiz numara üretme algoritması ve kullanılan numaraların takibi `Account` sınıfından soyutlanarak bağımsız bir yardımcı sınıf olan `NumberGenerator` içerisine taşınmıştır.
* **DRY (Don't Repeat Yourself):** ID, IBAN ve Hesap No üretimindeki ortak rakam dizilimi tek bir çekirdek metot üzerinden türetilerek kod tekrarı ortadan kaldırılmıştır.
* **Exception Handling (Hata Yönetimi):** Geçersiz parametreler ve kural ihlallerinde (`IllegalArgumentException`, `IllegalStateException`) standart istisnalar fırlatılarak sistem stabilitesi korunmuştur.

---

## 🧱 Sınıf Yapısı

* **`Account`**: Müşteri bilgileri, IBAN, hesap numarası ve bakiye hareketlerini yöneten ana hesap modeli.
* **`SavingsAccount`**: `Account` sınıfından türetilen ve para yatırma hareketlerinde bonus puan kazandıran birikim hesabı modeli.
* **`NumberGenerator`**: Benzersiz ID, IBAN ve hesap numarası üreten yardımcı (utility) sınıf.
* **`Main`**: Konsol menüsünü çalıştıran, kullanıcı etkileşimini ve girdi yönetimini sağlayan başlangıç noktası.

---

## 💻 Kullanılan Teknolojiler

* **Dil:** Java (JDK 17+)
* **Temel Yapılar:** Java Collections Framework (`Set`, `HashSet`), `java.math.BigDecimal`, `java.security.SecureRandom`

---

## 📂 Kurulum ve Çalıştırma

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/MertTemizcan/Bank-Management-System.git](https://github.com/MertTemizcan/Bank-Management-System.git)

2. Projeyi Çalıştırın
