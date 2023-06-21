import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayItems() {
        System.out.println("Shopping Cart:");
        for (Product item : items) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.println("Total: $" + getTotalPrice());
    }
}

class ShopApp {
    private List<Product> products;
    private ShoppingCart cart;
    private Scanner scanner;

    public ShopApp() {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
    }

    public void start() {
        System.out.println("Welcome to the Shopping App!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    System.out.println("Thank you for using the Shopping App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addToCart() {
        System.out.print("Enter the name of the product: ");
        String productName = scanner.next();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                cart.addItem(product);
                System.out.println("Product added to cart.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    private void removeFromCart() {
        System.out.print("Enter the name of the product: ");
        String productName = scanner.next();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                cart.removeItem(product);
                System.out.println("Product removed from cart.");
                return;
            }
        }

        System.out.println("Product not found in the cart.");
    }

    private void viewCart() {
        cart.displayItems();
    }

    private void checkout() {
        cart.displayItems();
        System.out.println("Total: $" + cart.getTotalPrice());
        System.out.println("Thank you for your purchase!");
        cart = new ShoppingCart(); // Clear the cart after checkout
    }
}

public class app {
    public static void main(String[] args) {
        ShopApp shopApp = new ShopApp();

        // Adding some example products
        shopApp.addProduct(new Product("Product 1", 10.0));
        shopApp.addProduct(new Product("Product 2", 15.0));
        shopApp.addProduct(new Product("Product 3", 20.0));

        shopApp.start();
    }
}

