# Hesap Makinesi Modülü Test Otomasyonu Projesi

Bu proje, **finans uygulaması** için geliştirilen hesap makinesi modülünün kapsamlı şekilde test edilmesini ve otomasyonunun gerçekleştirilmesini amaçlamaktadır. Aşağıda proje kurulum talimatları, kullanım yönergeleri ve sık karşılaşılan sorunlara yönelik ipuçları sunulmuştur.

---

## İçindekiler
- [Proje Hakkında](#proje-hakkında)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Otomasyon Senaryoları](#otomasyon-senaryoları)
- [Raporlama](#raporlama)
- [Sık Karşılaşılan Sorunlar ve Çözümleri](#sık-karşılaşılan-sorunlar-ve-çözümleri)
- [Katkıda Bulunanlar](#katkıda-bulunanlar)

---

## Proje Hakkında

Bu proje, hesap makinesi modülünde aşağıdaki hesaplama türlerinin test edilmesini kapsamaktadır:
- Yatırım hesaplaması
- Aylık bütçe hesaplaması
- Kredi karşılaştırması
- Kısa vadeli yatırım hesaplaması
- Günlük gider takibi
- Döviz dönüşümü

Modülün **UI (kullanıcı arayüzü)** ve **API katmanları** üzerinde gerçekleştirilecek fonksiyonel testler için **Selenium** kullanılmıştır. Test otomasyonu için **Gauge** ve **Java** kullanılarak raporlama işlemi **ExtentReports** ile yapılmıştır.

---

## Kurulum

### 1. Gerekli Yazılımlar
Aşağıdaki araçları yükleyin:
- [Java 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Gauge](https://gauge.org/get-started/)
- [ChromeDriver](https://chromedriver.chromium.org/downloads) (Tarayıcı ile uyumlu versiyonu seçin)

### 2. Projenin Çalıştırılması
1. Projeyi klonlayın:
   ```bash
   git clone <REPO_URL>
   cd <PROJE_KLASÖRÜ>

### Raporlama
ExtentReports rapor formatı aşağıdaki detayları içerir:

Başarı, hata ve atlanan test adımları
Test senaryosu adımları ve ekran görüntüleri (hata durumlarında otomatik alınır)
Rapor Oluşturma Komutu:
   ```bash
   mvn gauge:execute -DspecsDir=specs -Dtags="rapor"
