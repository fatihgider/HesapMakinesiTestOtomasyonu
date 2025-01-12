Hesap Makinesi Kredi Karşılaştırma Senaryoları
=====================
//FAIL(eksik basamak gösterimi)
Kredi 1 için hesaplanma yapılması
----------------
tags:HMM21-KK1
* Sayfa açılır
* Giriş yapılır ve hesap makinesi açılır
* "12" ve "100" sayıları ile "bölme" işlemi yapılır ve sonucun "0,12" olduğu kontrol edilir
* "0,12" ve "12" sayıları ile "bölme" işlemi yapılır ve sonucun "0,01" olduğu kontrol edilir
* "0,01" ve "1" sayıları ile "toplama" işlemi yapılır ve sonucun "1,01" olduğu kontrol edilir
* "1,01" üzeri "12" işlemi yapılır
* Sonuç "1,1268" olmalıdır
* "1,1268" ve "0,01" sayıları ile "çarpma" işlemi yapılır ve sonucun "0,011268" olduğu kontrol edilir
* "0,011268" ve "1200" sayıları ile "çarpma" işlemi yapılır ve sonucun "13,5216" olduğu kontrol edilir
* "1,1268" ve "1" sayıları ile "çıkarma" işlemi yapılır ve sonucun "0,1268" olduğu kontrol edilir
* "13,5216" ve "0,1268" sayıları ile "bölme" işlemi yapılır ve sonucun "106,63" olduğu kontrol edilir

//FAIL(yanlış hesaplanma)
Kredi 2 için hesaplanma yapılması
----------------
tags:HMM22-KK2
* Sayfa açılır
* Giriş yapılır ve hesap makinesi açılır
* "6" ve "100" sayıları ile "bölme" işlemi yapılır ve sonucun "0,06" olduğu kontrol edilir
* "0,6" ve "12" sayıları ile "bölme" işlemi yapılır ve sonucun "0,005" olduğu kontrol edilir
* "0,005" ve "1" sayıları ile "toplama" işlemi yapılır ve sonucun "1,005" olduğu kontrol edilir
* "1,005" üzeri "6" işlemi yapılır
* Sonuç "1,0617" olmalıdır
* "1,0617" ve "0,005" sayıları ile "çarpma" işlemi yapılır ve sonucun "0,0053085" olduğu kontrol edilir
* "0,0053085" ve "1600" sayıları ile "çarpma" işlemi yapılır ve sonucun "8,4936" olduğu kontrol edilir
* "1,0617" ve "1" sayıları ile "çıkarma" işlemi yapılır ve sonucun "0,0617" olduğu kontrol edilir
* "8,4936" ve "0,0617" sayıları ile "bölme" işlemi yapılır ve sonucun "50,36" olduğu kontrol edilir

//FAIL(eksik basamak gösterimi)
Kredi 3 için hesaplanma yapılması
----------------
tags:HMM23-KK3
* Sayfa açılır
* Giriş yapılır ve hesap makinesi açılır
* "24" ve "100" sayıları ile "bölme" işlemi yapılır ve sonucun "0,24" olduğu kontrol edilir
* "0,24" ve "12" sayıları ile "bölme" işlemi yapılır ve sonucun "0,02" olduğu kontrol edilir
* "0,02" ve "1" sayıları ile "toplama" işlemi yapılır ve sonucun "1,02" olduğu kontrol edilir
* "1,02" üzeri "6" işlemi yapılır
* Sonuç "1,1261" olmalıdır
* "1,1261" ve "0,02" sayıları ile "çarpma" işlemi yapılır ve sonucun "0,0225" olduğu kontrol edilir
* "0,0225" ve "1300" sayıları ile "çarpma" işlemi yapılır ve sonucun "29,25" olduğu kontrol edilir
* "1,1261" ve "1" sayıları ile "çıkarma" işlemi yapılır ve sonucun "0,1261" olduğu kontrol edilir
* "29,25" ve "0,1261" sayıları ile "bölme" işlemi yapılır ve sonucun "231,95" olduğu kontrol edilir

Sıfıra Bölme İşlemi
----------------
tags:HMM023-GENEL01
* Sayfa açılır
* Giriş yapılır ve hesap makinesi açılır
* "10" sayısı yazılır
* "/" butonuna tıklanır
* "0" sayısı yazılır
* "=" butonuna tıklanır
* "Not a Number" metni sayfada görüntülenebilir olmalıdır