import java.util.ArrayList;
import java.util.List;

class ProductSearch {
    // Search for products containing the specified keyword in the name
    public List<Product> searchByKeyword(List<Product> products, String keyword) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    // Filter products by price range
    public List<Product> filterByPriceRange(List<Product> products, double minPrice, double maxPrice) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            double productPrice = product.getPrice();
            if (productPrice >= minPrice && productPrice <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    // Filter products by category
    public List<Product> filterByCategory(List<Product> products, String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

}


