import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<Integer, Product> products; // Ürünleri ID ile yönetiyoruz
    private Map<Integer, Order> orders; // Siparişleri ID ile yönetiyoruz
    private Map<Integer, Integer> stock; // Ürün ID'si ile stok miktarı
    private int orderIdCounter = 1; // Sipariş ID'si için sayaç
    private int productIdCounter = 1; // Ürün ID'si için sayaç


    /*
    Store sınıfının bir örneği oluşturulduğunda, products, orders, ve stock veri yapıları başlatılır.
     Bu, ürünleri, siparişleri ve stokları yönetmek için gereken boş koleksiyonları sağlar.
     */
    public Store() {
        products = new HashMap<>();
        orders = new HashMap<>();
        stock = new HashMap<>();
    }

    /*Yeni bir ürün ekleme*/
    public void addProduct(String name, double price, String description, int initialStock, String unit) {
        Product product = new Product(productIdCounter++, name, price, description, unit);
        products.put(product.getId(), product);
        stock.put(product.getId(), initialStock);
    }

    /*
    Ürün ID'si, adı, fiyatı ve birimi ile birlikte tabular formatta listeler.
    Ürünleri products koleksiyonundan alır ve her ürünün bilgilerini yazdırır.
    Ürünleri Listeler
     */
    public void listProducts() {
        System.out.println("\nMevcut Ürünler:");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Ad", "Fiyat", "Birim");
        System.out.println("-----------------------------------------");
        for (Product product : products.values()) {
            System.out.printf("%-10d %-20s ₺%-10.2f %-10s%n", product.getId(), product.getName(), product.getPrice(), product.getUnit());
        }
    }

    /*
    Ürün adını products koleksiyonundaki ürünlerle karşılaştırır.
    Ürün bulunduğunda, ürünün adı, fiyatı, açıklaması, birimi ve mevcut stok miktarını gösterir.
    Ürün bulunamadığında uygun bir mesaj verir.Detaylar

     */
    public void showProductDetailsByName(String productName) {
        Product product = null;
        for (Product p : products.values()) {
            if (p.getName().equalsIgnoreCase(productName)) {
                product = p;
                break;
            }
        }

        Integer currentStock = (product != null) ? stock.get(product.getId()) : null;

        if (product != null) {
            System.out.println("\nÜrün Detayları:");
            System.out.printf("Ad: %s%n", product.getName());
            System.out.printf("Fiyat: ₺%.2f%n", product.getPrice());
            System.out.printf("Açıklama: %s%n", product.getDescription());
            System.out.printf("Birim: %s%n", product.getUnit());
            System.out.printf("Stok Miktarı: %d%n", (currentStock != null ? currentStock : 0));
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }

    /*
    Ürün ID'si ve miktarını alır.
    Ürünün stok miktarını kontrol eder. Eğer yeterli stok varsa, satış işlemi yapılır.
    Ürünün fiyatı ile miktarını çarparak toplam fiyatı hesaplar.
    Stok miktarını günceller ve yeni bir sipariş oluşturur.
    Sipariş ID'sini orderIdCounter kullanarak benzersiz yapar.
    Sipariş oluşturur ve sipariş koleksiyonuna ekler.
    Stok yetersizliği veya ürün bulunamadığında uygun bir mesaj verir.
    Belirli bir ürünün satışını gerçekleştirir.İşlev
     */
    public double sellProduct(int productId, int quantity) {
        Product product = products.get(productId);
        Integer currentStock = stock.get(productId);
        if (product != null && currentStock != null && currentStock >= quantity) {
            double totalPrice = product.getPrice() * quantity;
            stock.put(productId, currentStock - quantity);
            Order order = new Order(orderIdCounter++, product, quantity);
            orders.put(order.getId(), order);
            return totalPrice;
        } else {
            System.out.println("Yetersiz stok veya ürün bulunamadı.");
            return 0.0;
        }
    }
    /*Tüm siparişleri listeler. sipariş bilgilerini orders sınıfından alır */
    public void listOrders() {
        System.out.println("\nSatışları Listele:");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "Sipariş ID", "Ürün Adı", "Miktar", "Toplam Fiyat");
        System.out.println("-----------------------------------------");
        for (Order order : orders.values()) {
            System.out.printf("%-10d %-20s %-10d ₺%-10.2f%n", order.getId(), order.getProduct().getName(), order.getQuantity(), order.getTotalPrice());
        }
    }
    /*
    Ürünleri IDlerine göre saklayan koleksiyonu döndürür
    Ürün ve siparişler için getter yönetemleri
     */
    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Map<Integer, Integer> getStock() {
        return stock;
    }
}
