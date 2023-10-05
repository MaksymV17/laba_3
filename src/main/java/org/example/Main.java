import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Ноутбук", 999.99));
        products.add(new Product(2, "Смартфон", 499.99));
        products.add(new Product(3, "Планшет", 299.99));

        // Створюємо кошик
        Cart cart = new Cart();

        // Створюємо список для зберігання замовлень
        List<Order> orders = new ArrayList<>();

        // Створюємо об'єкт Scanner для введення користувача
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Виводимо вміст кошика
            List<Product> cartItems = cart.getProducts();
            System.out.println("Продукти у кошику:");
            for (int i = 0; i < cartItems.size(); i++) {
                Product product = cartItems.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " (ID: " + product.getId() + ") - " + product.getPrice());
            }

            // Виводимо меню користувача
            System.out.println("Меню:");
            System.out.println("1. Додати продукт до кошика за ID");
            System.out.println("2. Видалити продукт з кошика");
            System.out.println("3. Перевірити статус замовлення");
            System.out.println("4. Зробити замовлення");
            System.out.println("5. Вийти");

            // Очікуємо вибір користувача
            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Додаємо продукт до кошика за ID
                    System.out.print("Введіть ID продукту, який ви хочете додати: ");
                    int productIdToAdd = scanner.nextInt();
                    Product productToAdd = findProductById(products, productIdToAdd);
                    if (productToAdd != null) {
                        cart.addToCart(productToAdd);
                        System.out.println("Продукт додано до кошика.");
                    } else {
                        System.out.println("Продукт з вказаним ID не знайдено.");
                    }
                    break;

                case 2:
                    // Видаляємо продукт з кошика
                    System.out.print("Введіть номер продукту, який ви хочете видалити: ");
                    int productToRemoveIndex = scanner.nextInt();
                    if (productToRemoveIndex >= 1 && productToRemoveIndex <= cartItems.size()) {
                        cart.removeFromCart(cartItems.get(productToRemoveIndex - 1));
                        System.out.println("Продукт видалено з кошика.");
                    } else {
                        System.out.println("Некоректний номер продукту.");
                    }
                    break;

                case 3:
                    // Перевіряємо статус замовлення
                    System.out.print("Введіть номер замовлення: ");
                    int orderNumber = scanner.nextInt();
                    if (orderNumber >= 1 && orderNumber <= orders.size()) {
                        Order order = orders.get(orderNumber - 1);
                        order.displayOrderDetails(); // Викликаємо метод для відображення деталей замовлення
                    } else {
                        System.out.println("Замовлення з вказаним номером не знайдено.");
                    }
                    break;

                case 4:
                    // Робимо замовлення з товарів у кошику
                    if (!cart.isEmpty()) {
                        Order order = new Order(new ArrayList<>(cart.getProducts())); // Створюємо копію списку товарів з кошика
                        orders.add(order);
                        cart.clearCart(); // Очищаємо кошик
                        System.out.println("Замовлення створено. Номер замовлення: " + order.getOrderId());
                    } else {
                        System.out.println("Кошик порожній. Додайте товари до кошика перед створенням замовлення.");
                    }
                    break;

                case 5:
                    // Завершуємо програму
                    System.out.println("Дякуємо за використання нашої програми!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }

    // Метод для пошуку продукту за ID
    private static Product findProductById(List<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product; // Знайдено продукт з вказаним ID
            }
        }
        return null; // Продукт з вказаним ID не знайдено
    }
}
