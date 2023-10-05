import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderTests {
    private Order order1;
    private Order order2;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        product1 = new Product(1, "Ноутбук", 999.99);
        product2 = new Product(2, "Смартфон", 499.99);

        // Створюємо два замовлення з різними наборами товарів
        order1 = new Order(new ArrayList<>(Arrays.asList(product1)));
        order2 = new Order(new ArrayList<>(Arrays.asList(product2)));
    }

    @Test
    public void testOrderCreation() {
        assertNotNull(order1);
        assertNotNull(order2);
    }

    @Test
    public void testGetProductsInOrder() {
        List<Product> productsInOrder1 = order1.getProducts();
        List<Product> productsInOrder2 = order2.getProducts();

        assertTrue(productsInOrder1.contains(product1));
        assertFalse(productsInOrder1.contains(product2));

        assertFalse(productsInOrder2.contains(product1));
        assertTrue(productsInOrder2.contains(product2));
    }

    @Test
    public void testGetStatus() {
        assertEquals("Нове", order1.getStatus());
        assertEquals("Нове", order2.getStatus());
    }

    @Test
    public void testSetStatus() {
        order1.setStatus("Виконане");
        assertEquals("Виконане", order1.getStatus());

        order2.setStatus("Скасоване");
        assertEquals("Скасоване", order2.getStatus());
    }
}
