import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart(Product product) {
        products.add(product);
    }

    public void removeFromCart(Product product) {
        products.remove(product);
    }

    public void clearCart() {
        products.clear();
    }

    // Додайте метод isEmpty(), який повертатиме true, якщо кошик порожній, інакше false.
    public boolean isEmpty() {
        return products.isEmpty();
    }
}
