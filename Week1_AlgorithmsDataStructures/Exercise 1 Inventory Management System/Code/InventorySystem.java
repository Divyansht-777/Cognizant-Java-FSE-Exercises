import java.util.HashMap;
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

public class InventorySystem {

    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added.");
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = newQuantity;
            p.price = newPrice;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        Product p1 = new Product(101, "Laptop", 10, 59999.99);
        Product p2 = new Product(102, "Mouse", 50, 499.50);
        Product p3 = new Product(103, "Keyboard", 30, 799.00);

        system.addProduct(p1);
        system.addProduct(p2);
        system.addProduct(p3);

        system.showInventory();

        system.updateProduct(102, 60, 450.00);
        system.deleteProduct(103);

        System.out.println("\nAfter updates:");
        system.showInventory();
    }
}
