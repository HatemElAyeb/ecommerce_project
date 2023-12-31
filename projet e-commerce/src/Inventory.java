import java.util.HashMap;
import java.util.Map;

class Inventory {
    private Map<Product, Integer> productQuantities;

    public Inventory() {
        this.productQuantities = new HashMap<>();
    }

    // Add products to the inventory with an initial quantity
    public void addProduct(Product product, int initialQuantity) {
        productQuantities.put(product, initialQuantity);
    }

    // Update product quantity in the inventory
    public void updateProductQuantity(Product product, int newQuantity) {
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, newQuantity);
            System.out.println("Inventory updated for product: " + product.getProductName());
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    // Check if a product is in stock
    public boolean isInStock(Product product, int quantity) {
        return productQuantities.getOrDefault(product, 0) >= quantity;
    }

    // Reduce product quantity after purchase
    public void reduceProductQuantity(Product product, int quantity) {
        if (isInStock(product, quantity)) {
            int currentQuantity = productQuantities.get(product);
            productQuantities.put(product, currentQuantity - quantity);
            System.out.println("Inventory updated after purchase: " + product.getProductName());
        } else {
            System.out.println("Product is out of stock.");
        }
    }

    // Display details of the inventory
    public void displayInventory() {
        System.out.println("Inventory Details:");
        for (Map.Entry<Product, Integer> entry : productQuantities.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getProductName() + " - Quantity: " + quantity);
        }
    }
}
