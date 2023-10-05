import java.util.List;

public class Order {
    private static int nextOrderId = 1;

    private int orderId;
    private List<Product> products;
    private String status;

    public Order(List<Product> products) {
        this.orderId = nextOrderId++;
        this.products = products;
        this.status = "Нове";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Додайте метод для відображення списку товарів у замовленні
    public void displayOrderDetails() {
        System.out.println("Замовлення #" + orderId + ": " + status);
        System.out.println("Товари у замовленні:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " (ID: " + product.getId() + ") - " + product.getPrice());
        }
    }
}
