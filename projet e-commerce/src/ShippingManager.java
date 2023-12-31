import java.util.HashMap;
import java.util.Map;

public class ShippingManager {
    private Map<String, Double> shippingRates;

    public ShippingManager() {
        // Initialize shipping rates for different shipping methods
        shippingRates = new HashMap<>();
        shippingRates.put("standard", 5.0);
        shippingRates.put("express", 10.0);
        shippingRates.put("overnight", 20.0);
    }

    // Getters and setters for shipping rates (optional)

    public void setShippingRate(String shippingMethod, double rate) {
        shippingRates.put(shippingMethod, rate);
    }

    public double getShippingRate(String shippingMethod) {
        return shippingRates.getOrDefault(shippingMethod, 0.0);
    }

    // Method to select a shipping method
    public void selectShippingMethod(String shippingMethod) {
        System.out.println("Selected shipping method: " + shippingMethod);
    }

    // Method to calculate shipping cost based on the selected method and the total quantity of products in the cart
    public double calculateShippingCost(String shippingMethod, ShoppingCart cart) {
        int totalQuantity = cart.getTotalQuantity();
        double rate = shippingRates.getOrDefault(shippingMethod, 0.0);
        return rate * totalQuantity;
    }

    // Display shipping information
    public void displayShippingInfo(String shippingMethod, ShoppingCart cart) {
        System.out.println("Your Order:");
        System.out.println("Shipping Method: " + shippingMethod);
        cart.displayCart();
        double shippingCost = calculateShippingCost(shippingMethod, cart);
        double total=shippingCost+cart.calculateTotalCartPrice();
        System.out.println("Shipping Cost: $" + shippingCost);
        System.out.println("Total Cost: $" +total);
    }
}
