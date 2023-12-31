import java.util.ArrayList;
import java.util.List;
class Orders {
    private List<Order> orderList;

    public Orders() {
        this.orderList = new ArrayList<>();
    }

    // Add a new order to the list
    public void addOrder(Order order) {
        orderList.add(order);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderList);
    }

    // Retrieve orders for a specific user
    public List<Order> getOrdersForUser(User user) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUser().equals(user)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    // Display details of all orders
    public void displayAllOrders() {
        for (Order order : orderList) {
            System.out.println(order.toString());
        }
    }
}
