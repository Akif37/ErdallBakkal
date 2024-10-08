# Mağaza Yönetim Sistemi

## Genel Bakış ve Tanım
Mağaza Yönetim Sistemi, Java kullanarak geliştirilmiş basit bir konsol uygulamasıdır. Bu uygulama, kullanıcıların ürünleri yönetmesine, satış işlemlerini gerçekleştirmesine ve sipariş detaylarını görüntülemesine olanak tanır. Konsol tabanlı bir arayüz ile kullanıcı dostu bir deneyim sunar.

## Özellikler
- **Ürünleri Listele**: Tüm mevcut ürünleri fiyat, stok durumu ve açıklama gibi detaylarla birlikte görüntüler.
- **Ürün Ekle**: Yeni ürünler ekleyerek mağaza envanterini güncelleme olanağı sunar. Ürün adı, fiyat, açıklama, başlangıç stok miktarı ve birim bilgilerini alır.
- **Ürün Satışı**: Kullanıcıların ürün adlarını ve miktarlarını girerek satış işlemleri yapmasına imkan tanır. Satış sonrası toplam tutar otomatik olarak hesaplanır.
- **Satışları Listele**: Yapılan tüm satış işlemlerini görüntüleyerek raporlama yapmayı kolaylaştırır.
- **Ürün Detaylarını Görüntüle**: Belirli bir ürün hakkında detaylı bilgi almayı sağlar, böylece kullanıcılar ürünlerin özelliklerini daha iyi anlayabilir.
- **Çıkış**: Kullanıcıların uygulamadan güvenli bir şekilde çıkmasını sağlar.

## Başlangıç Gereksinimleri
- Bilgisayarınızda Java Geliştirme Kiti (JDK) yüklü olmalı (sürüm 8 veya daha yüksek).
- Java kodunu düzenlemek için bir metin editörü veya Entegre Geliştirme Ortamı (IDE) (örneğin, IntelliJ IDEA, Eclipse).

## Kullanım
Uygulama çalıştırıldığında, aşağıdaki seçenekleri içeren bir menü görüntülenecektir:
1. **Ürünleri Listele**: Tüm ürünleri ve detaylarını gösterir.
2. **Ürün Ekle**: Yeni bir ürün eklemek için gerekli bilgileri girmenizi sağlar.
3. **Ürün Satış**: Ürün adını ve miktarını girerek satış işlemi yapmanıza olanak tanır. Her satış sonrası toplam tutar görüntülenir.
4. **Satışları Listele**: Yapılan tüm satışları gösterir.
5. **Ürün Detaylarını Görüntüle**: Ürün adını girerek detaylarını görmenizi sağlar.
6. **Çıkış**: Uygulamayı kapatır.

## Örnek Kullanım
- Bir ürün eklemek için 2. seçeneği seçin ve istenen bilgileri girin.
- Bir ürün satışı yapmak için 3. seçeneği seçin, ardından ürün adını ve miktarını girin.

## Kurulum
1. Java JDK'yı bilgisayarınıza indirin ve kurun.
2. Projeyi klonlayın veya indirin.
3. Proje klasöründe terminal veya komut istemcisini açın.
4. Uygulamayı çalıştırmak için aşağıdaki komutu kullanın:
   ```bash
   javac Main.java
   java Main
