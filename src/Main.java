import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Kullanıcıdan girdi almak için Scanner nesnesi oluştur.
        Store store = new Store();// Store sınıfından bir nesne oluştur.

        /*  Başlangıçta mağazaya bazı ürünler ekle.*/
        store.addProduct("Süt", 25.0, "Taze süt", 10, "litre");
        store.addProduct("Ekmek", 10.0, "Tam buğday ekmeği", 15, "adet");
        store.addProduct("Yumurta", 30.0, "12'li yumurta", 12, "paket");

        /*
        Kullanıcıdan seçim almak için bir döngü kullanıyor (while (true)),
        bu sayede kullanıcı istediği işlemi gerçekleştirebilir:
         */
        label58:// Döngünün etiketi
        while (true) {
            System.out.println("\n1. Ürünleri Listele");
            System.out.println("2. Ürün Ekle");
            System.out.println("3. Ürün Satış");
            System.out.println("4. Satışları Listele");
            System.out.println("5. Ürün Detayları");
            System.out.println("6. Çıkış");
            System.out.print("Bir seçenek girin: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String productName;
            switch (choice) {
                case 1:// Ürünleri listele
                    store.listProducts();
                    break;
                case 2:// Yeni ürün ekle
                    System.out.print("Ürün adı: ");
                    String name = scanner.nextLine();
                    System.out.print("Ürün fiyatı: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ürün açıklaması: ");
                    String description = scanner.nextLine();
                    System.out.print("Başlangıç stok miktarı: ");
                    int initialStock = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ürün birimi (adet, kg, paket vb.): ");
                    String unit = scanner.nextLine();
                    store.addProduct(name, price, description, initialStock, unit);
                    System.out.println("Ürün başarıyla eklendi.");
                    break;
                case 3:// Ürün satış işlemi
                    double totalAmount = 0.0;

                    while (true) {
                        System.out.print("Ürün adı girin (işlemi bitirmek için 'son' yazın): ");
                        productName = scanner.nextLine();
                        if (productName.equalsIgnoreCase("son")) {
                            System.out.println("Toplam tutar: ₺" + totalAmount);
                            continue label58;
                        }

                        System.out.print("Miktar girin: ");

                        int quantity;
                        try {
                            quantity = scanner.nextInt();
                            scanner.nextLine();
                        } catch (NumberFormatException var19) {
                            System.out.println("Geçersiz miktar. Lütfen tekrar deneyin.");
                            scanner.nextLine();
                            continue;
                        }

                        boolean found = false;
                        Iterator var15 = store.getProducts().values().iterator();

                        while (var15.hasNext()) {
                            Product product = (Product) var15.next();
                            if (product.getName().equalsIgnoreCase(productName)) {
                                double orderPrice = store.sellProduct(product.getId(), quantity);
                                if (orderPrice > 0.0) {
                                    totalAmount += orderPrice;
                                    System.out.println("Siparişinize " + quantity + " adet " + productName + " eklendi.");
                                    System.out.println("Şu anki toplam: ₺" + totalAmount);
                                } else {
                                    System.out.println("Yetersiz stok veya ürün bulunamadı.");
                                }

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Ürün bulunamadı.");
                        }
                    }
                case 4:// Satışları listele
                    store.listOrders();
                    break;
                case 5:// Ürün detaylarını göster
                    System.out.print("Detaylarını görmek istediğiniz ürün adını girin: ");
                    productName = scanner.nextLine();
                    store.showProductDetailsByName(productName);
                    break;
                case 6:// Çıkış işlemi
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}
