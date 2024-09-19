public class Product {
    private int id;
    private String name;
    private double price;
    private String description; // İsteğe bağlı açıklama
    private String unit; // Ürünün satıldığı birim (adet, kg, paket vb.)

    /*
    Görevi Product sınıfının bir örneğini oluşturur.
    Bu özellikler ürünün tüm bilgilerini temsil eder ve sınıfın her örneği için ayarlanabilir.
     */
    public Product(int id, String name, double price, String description, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.unit = unit;
    }

    /*
    Getters and Setters
    Ürünün değerlerini döner
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    /*Ürünün bilgilerini metin formatında döndürür.*/
    @Override
    public String toString() {
        return String.format("Ürün{id=%d, ad='%s', fiyat=%.2f, açıklama='%s', birim='%s'}", id, name, price, description, unit);
    }
}
