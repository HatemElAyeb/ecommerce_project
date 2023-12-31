
import java.util.ArrayList;
import java.util.List;
// Order class to represent a user's order
class Order {
    private List<CartItem> orderedItems;
    private double totalCartPrice;
    private double shippingCost;
    private OrderStatus orderStatus;
    private User user;

    public Order(List<CartItem> cartItems, double totalCartPrice, double shippingCost, OrderStatus orderStatus, User user) {
        this.orderedItems = new ArrayList<>(cartItems);
        this.totalCartPrice = totalCartPrice;
        this.shippingCost = shippingCost;
        this.orderStatus = orderStatus;
        this.user = user;
    }

    // Getters and setters

    public double getTotalCartPrice() {
        return totalCartPrice;
    }

    public List<CartItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<CartItem> orderedItems) {
        this.orderedItems = orderedItems;
    }



    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order Details for user: ").append(user.getUsername()).append("\n");
        for (CartItem orderedItem : orderedItems) {
            orderDetails.append(orderedItem.toString()).append("\n");
        }
        orderDetails.append("Total Price: ").append(totalCartPrice).append(" DT\n");
        orderDetails.append("Order Status: ").append(orderStatus);
        return orderDetails.toString();
    }
}
enum OrderStatus {
    PENDING, PROCESSING, SHIPPED, CANCELED
}
