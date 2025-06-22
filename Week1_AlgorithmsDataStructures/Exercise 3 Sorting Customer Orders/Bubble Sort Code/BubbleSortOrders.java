class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total: " + totalPrice;
    }
}

public class BubbleSortOrders {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(201, "Alice", 350.5),
            new Order(202, "Bob", 200.0),
            new Order(203, "Charlie", 420.0),
            new Order(204, "Diana", 270.75)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        bubbleSort(orders);

        System.out.println("\nOrders Sorted by Bubble Sort:");
        printOrders(orders);
    }
}
