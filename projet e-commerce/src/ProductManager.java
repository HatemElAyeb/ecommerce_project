import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    // Create (add) a new product
    public void addProduct(Product product) {
        products.add(product);
    }
    public int getNextProductId() {
        // Calculate the next product ID based on the number of existing products
        return products.size() + 1;
    }
    // Read (get) a product by ID
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        System.out.println("Product not found with ID: " + productId);
        return null;
    }
    private static Scanner scanner = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    // Update an existing product
    public void updateProduct(int productId,Inventory inventory) {
        Product productToUpdate = getProductById(productId);
        if (productToUpdate == null) {
            System.out.println("Product not found. Update failed.");
            return;
        }

        System.out.println(ANSI_CYAN+"Update product - Product ID:"+ANSI_RESET + productId);
        System.out.println("1."+ANSI_BLUE+" Update Product Name"+ANSI_RESET);
        System.out.println("2."+ANSI_BLUE+" Update Price"+ANSI_RESET);
        System.out.println("3."+ANSI_BLUE+" Update Quantity"+ANSI_RESET);

        // Add category-specific update options
        if (productToUpdate instanceof ElectronicsProduct) {
            System.out.println("4."+ANSI_BLUE+" Update Brand"+ANSI_RESET);
        } else if (productToUpdate instanceof FoodProduct) {
            System.out.println("4."+ANSI_BLUE+" Update ExpirationDate"+ANSI_RESET);
        } else if (productToUpdate instanceof ClothingProduct) {
            System.out.println("4."+ANSI_BLUE+" Update Size"+ANSI_RESET);
        } else if (productToUpdate instanceof BookProduct) {
            System.out.println("4."+ANSI_BLUE+" Update Author"+ANSI_RESET);
        }

        int choice = Main2.getIntInput("Enter your choice (0 to cancel): ");

        switch (choice) {
            case 1:
                String updatedName = Main2.getStringInput("Enter the updated product name: ");
                productToUpdate.setProductName(updatedName);
                break;
            case 2:
                double updatedPrice = Main2.getDoubleInput("Enter the updated price: ");
                productToUpdate.setPrice(updatedPrice);
                break;
            case 3:
                int updatedQuantity = Main2.getIntInput("Enter the updated quantity: ");
                inventory.updateProductQuantity(productToUpdate,updatedQuantity);
                break;
            case 4:
                // Add category-specific attribute update logic
                if (productToUpdate instanceof ElectronicsProduct) {
                    String updatedBrand = Main2.getStringInput("Enter the updated brand: ");
                    ((ElectronicsProduct) productToUpdate).setBrand(updatedBrand);
                } else if (productToUpdate instanceof FoodProduct) {
                    String updatedExpirationDate = Main2.getStringInput("Enter the updated expiration date (e.g., YYYY-MM-DD): ");
                    ((FoodProduct) productToUpdate).setExpirationDate(updatedExpirationDate);
                } else if (productToUpdate instanceof ClothingProduct) {
                    String updatedSize = Main2.getStringInput("Enter the updated size: ");
                    ((ClothingProduct) productToUpdate).setSize(updatedSize);
                } else if (productToUpdate instanceof BookProduct) {
                    String updatedAuthor = Main2.getStringInput("Enter the updated author: ");
                    ((BookProduct) productToUpdate).setAuthor(updatedAuthor);
                }
                break;
            case 0:
                System.out.println("Update canceled.");
                return;
            default:
                System.out.println("Invalid choice. Update canceled.");
                return;
        }

        System.out.println("Product updated successfully.");
    }

    // Delete a product by ID
    public void deleteProduct(int productId) {
        Product productToRemove = getProductById(productId);
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found for deletion.");
        }
    }

    // Display all products
    public void displayAllProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    public void displayProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                System.out.println(product.toString());
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);
    }
}
