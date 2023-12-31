import java.util.ArrayList;
import java.util.List;
// Abstract Product class
abstract class Product {
    private int productId;
    private String productName;
    private double price;
    private String category;
    private List<Review> reviews;
    private double rating;

    public Product(int productId, String productName, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.reviews = new ArrayList<>();
        this.rating = 0.0; // Initial rating
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Review> getReviews() {
        return new ArrayList<>(reviews);
    }

    public double getRating() {
        return rating;
    }

    public void updateRating() {
        if (!reviews.isEmpty()) {
            double totalRating = 0.0;
            for (Review review : reviews) {
                totalRating += review.getRating();
            }
            rating = totalRating / reviews.size();
        }
    }

    public void addReview(Review review) {
        // Check if a review from the same user already exists
        for (Review existingReview : reviews) {
            if (existingReview.getUsername().equals(review.getUsername())) {
                System.out.println("You have already submitted a review for this product.");
                return; // Do not add the new review if one from the same user already exists
            }
        }

        // Add the new review to the list
        reviews.add(review);
        System.out.println("Review added successfully.");
        updateRating();
    }

    @Override
    public String toString() {
        return "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", rating=" + rating + "⭐"+"("+reviews.size()+" reviews)";
    }
}
// ElectronicsProduct class extending Product

class ElectronicsProduct extends Product {
    private String brand;

    public ElectronicsProduct(int productId, String productName, double price, String brand) {
        super(productId, productName, price,"Electronics");
        this.brand = brand;
    }

    // Getters and setters for ElectronicsProduct specific attribute (brand)

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}
// ClothingProduct class extending Product
class ClothingProduct extends Product {
    private String size;

    public ClothingProduct(int productId, String productName, double price, String size) {
        super(productId, productName, price,"Clothing");
        this.size = size;
    }

    // Getters and setters for ClothingProduct specific attribute (size)

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}
// BookProduct class extending Product
class BookProduct extends Product {
    private String author;
    private int pageCount;

    public BookProduct(int productId, String productName, double price, String author, int pageCount) {
        super(productId, productName, price,"Book");
        this.author = author;
        this.pageCount = pageCount;
    }

    // Getters and setters for BookProduct specific attributes (author, pageCount)

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Page Count: " + pageCount;
    }
}
// FoodProduct class extending Product
class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(int productId, String productName, double price, String expirationDate) {
        super(productId, productName, price,"Food");
        this.expirationDate = expirationDate;
    }

    // Getters and setters for FoodProduct specific attribute (expirationDate)

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate;
    }
}
