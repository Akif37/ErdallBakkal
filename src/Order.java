public class Order {
    private int id;
    private Product product;
    private Integer quantity;
    private Double totalPrice;

    /*Order sınıfının bir örneğini oluşturur.*/
    public Order(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }



    /*
    Getters and Setters
    Siparişin ID'si, ürünü, miktarı ve toplam fiyatı gibi bilgileri döndürür.
    */

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    /*Siparişin bilgilerini metin formatında döndürür.*/
    @Override
    public String toString() {
        return String.format("Sipariş{id=%d, ürün=%s, miktar=%d, toplamFiyat=%.2f}", id, product, quantity, totalPrice);
    }
}
