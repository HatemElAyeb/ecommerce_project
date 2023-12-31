import java.util.ArrayList;
import java.util.List;

// ShoppingCart class to manage products in the cart
class ShoppingCart {
    private List<CartItem> cartItems;
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
        this.cartItems = new ArrayList<>();
    }

    // Add a product to the cart
    public void addItem(Product product, int quantity) {
        // Check if the product is already in the cart
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getProductId() == product.getProductId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                System.out.println("Quantity updated in the cart.");
                return;
            }
        }

        // If the product is not in the cart, add a new CartItem
        CartItem newCartItem = new CartItem(product, quantity);
        cartItems.add(newCartItem);
    }

    // Update the quantity of a product in the cart
    public void updateItemQuantity(int productId, int newQuantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getProductId() == productId) {
                cartItem.setQuantity(newQuantity);
                System.out.println("Quantity updated in the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    // Remove a product from the cart
    public void removeItem(int productId) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getProductId() == productId) {
                cartItems.remove(cartItem);
                System.out.println("Product removed from the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }
    // Calculate the total price of items in the cart
    public double calculateTotalCartPrice() {
        double total = 0.0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return total;
    }
    // Display all items in the cart
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in the Cart:");
            for (CartItem cartItem : cartItems) {
                System.out.println(cartItem.toString());
            }
        }
    }
    //calculate the quantity (number of pieces bought) in order to calculate the shipping cost
    public int getTotalQuantity() {
        return cartItems.stream().mapToInt(CartItem::getQuantity).sum();
    }
    // Transition from the cart to order completion
    public Order checkout(String shippingMethod, ShippingManager shippingManager) {
        if (cartItems.isEmpty()) {
            System.out.println("Cannot complete the order. The cart is empty.");
            return null;
        }

        double totalCartPrice = calculateTotalCartPrice();
        double shippingCost = shippingManager.calculateShippingCost(shippingMethod, this);
        Order newOrder = new Order(new ArrayList<>(cartItems), totalCartPrice + shippingCost, shippingCost, OrderStatus.PENDING, user);
        cartItems.clear();
        System.out.println("Order placed successfully!");
        System.out.println(newOrder.toString());

        return newOrder;
    }
}
