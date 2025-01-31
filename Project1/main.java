import java.util.*;


interface StoreOperations {
    void addProduct(Product product);
    void buyProduct(int productID);
    void viewCart();
    void checkout();
}


abstract class Product {
    int productID;
    String name;
    double price;
    int stock;

    public Product(int productID, String name, double price, int stock) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract void display();
}


class StoreProduct extends Product {
    public StoreProduct(int productID, String name, double price, int stock) {
        super(productID, name, price, stock);
    }

    @Override
    public void display() {
        System.out.println("ID: " + productID + " | " + name + " | Price: Rs" + price + " | Stock: " + stock);
    }
}


class OnlineStore implements StoreOperations {
    private final List<Product> inventory = new ArrayList<>();
    private final Map<Product, Integer> cart = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        inventory.add(product);
    }

    @Override
    public void buyProduct(int productID) {
        for (Product product : inventory) {
            if (product.productID == productID) {
                if (product.stock > 0) {
                    cart.put(product, cart.getOrDefault(product, 0) + 1);
                    product.stock--;
                    System.out.println(product.name + " added to cart!");
                } else {
                    System.out.println("Sorry, " + product.name + " is out of stock.");
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }

    @Override
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey().name + " - Quantity: " + entry.getValue());
        }
    }

    @Override
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add products before checkout.");
            return;
        }
        double total = 0;
        System.out.println("Checkout Summary:");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double cost = quantity * product.price;
            System.out.println(product.name + " - " + quantity + " x $" + product.price + " = $" + cost);
            total += cost;
        }
        System.out.println("Total Amount: Rs" + total);
        cart.clear();
        System.out.println("Thank you for shopping!");
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : inventory) {
            product.display();
        }
    }
}


public class main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineStore store = new OnlineStore();

        
        store.addProduct(new StoreProduct(1, "Laptop", 750.0, 5));
        store.addProduct(new StoreProduct(2, "Phone", 500.0, 10));
        store.addProduct(new StoreProduct(3, "Headphones", 100.0, 15));

        while (true) {
            System.out.println("\n1. View Products\n2. Buy Product\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID to buy: ");
                    int productID = scanner.nextInt();
                    store.buyProduct(productID);
                    break;
                case 3:
                    store.viewCart();
                    break;
                case 4:
                    store.checkout();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
