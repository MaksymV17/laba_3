import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTests {
    private Cart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Ноутбук", 999.99);
        product2 = new Product(2, "Смартфон", 499.99);
    }

    @Test
    public void testAddToCart() {
        cart.addToCart(product1);
        assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveFromCart() {
        cart.addToCart(product1);
        cart.addToCart(product2);
        cart.removeFromCart(product1);
        assertFalse(cart.getProducts().contains(product1));
    }
}
