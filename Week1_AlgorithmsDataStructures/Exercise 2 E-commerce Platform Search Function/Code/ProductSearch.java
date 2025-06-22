import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ProductSearch {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shampoo", "Personal Care"),
            new Product(3, "Book", "Education"),
            new Product(4, "Phone", "Electronics"),
            new Product(5, "Chair", "Furniture")
        };

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, "Phone");
        if (result1 != null) {
            System.out.println("Found: " + result1.productName + " in " + result1.category);
        } else {
            System.out.println("Product not found.");
        }

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search (after sorting):");
        Product result2 = binarySearch(products, "Phone");
        if (result2 != null) {
            System.out.println("Found: " + result2.productName + " in " + result2.category);
        } else {
            System.out.println("Product not found.");
        }
    }
}
