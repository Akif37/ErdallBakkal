import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int id;
    private String username;
    private String password; // Şifreyi hash'lenmiş olarak saklıyoruz
    private String role;

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = hashPassword(password);
        this.role = role;
    }

    /*Burada ki hashleme yapısına çok hakim değilim gördüm ve kullanmak istedim.*/

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Şifre hashleme algoritması bulunamadı.", e);
        }
    }

    /* Getters and Setters değerleri döndürürler*/
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("Kullanıcı{id=%d, kullanıcı adı='%s', rol='%s'}", id, username, role);
    }
}
