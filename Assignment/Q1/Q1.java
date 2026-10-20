interface DeliveryStatus {
    void updateStatus(String status);
}

class Order {
    private final int orderId;
    private final String customerName;
    private final double amount;

    public Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    class OrderDetails {
        public void displayDetails() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Customer Name: " + customerName);
            System.out.printf("Amount: Rs. %.2f%n", amount);
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Order order = new Order(101, "Akash", 450.00);

        Order.OrderDetails details = order.new OrderDetails();
        details.displayDetails();

        DeliveryStatus deliveryStatus = new DeliveryStatus() {
            @Override
            public void updateStatus(String status) {
                System.out.println("\nStatus: " + status);

                switch (status) {
                    case "ORDER_PLACED":
                        System.out.println("Your order has been placed successfully.");
                        break;
                    case "PREPARING":
                        System.out.println("Your food is being prepared.");
                        break;
                    case "OUT_FOR_DELIVERY":
                        System.out.println("Your order is on its way.");
                        break;
                    case "DELIVERED":
                        System.out.println("Your order has been delivered. Enjoy your meal!");
                        break;
                    default:
                        System.out.println("Unknown delivery status.");
                }
            }
        };

        deliveryStatus.updateStatus("ORDER_PLACED");
        deliveryStatus.updateStatus("PREPARING");
        deliveryStatus.updateStatus("OUT_FOR_DELIVERY");
        deliveryStatus.updateStatus("DELIVERED");
    }
}
