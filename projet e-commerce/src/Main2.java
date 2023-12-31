import java.util.List;
import java.util.Scanner;
public class Main2 {
    private static Scanner scanner = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Orders orders=new Orders();
        Inventory inventory=new Inventory();
        ProductManager productManager=new ProductManager();
        UserDatabase userDatabase = new UserDatabase();


        LoginManager loginManager = new LoginManager(userDatabase);

        //--------------------------------------------------------------------------------
        User adminUser = new User("aa", "b", "admin");
        User customerUser = new User("a", "b", "customer");

        userDatabase.addUser(adminUser);
        userDatabase.addUser(customerUser);
        User admin = new User("admin", "adminpassword", "admin");
        userDatabase.addUser(admin);
        User customer1 = new User("customer1", "customer1password", "customer");
        User customer2 = new User("customer2", "customer2password", "customer");
        User customer3 = new User("customer3", "customer3password", "customer");
        User customer4 = new User("customer4", "customer4password", "customer");
        userDatabase.addUser(customer1);
        userDatabase.addUser(customer2);
        userDatabase.addUser(customer3);
        userDatabase.addUser(customer4);
        ElectronicsProduct camera = new ElectronicsProduct(productManager.getNextProductId(),"Digital Camera", 299.99,  "Sony");
        productManager.addProduct(camera);
        ElectronicsProduct laptop = new ElectronicsProduct(productManager.getNextProductId(), "Laptop", 1200.0, "Dell");
        productManager.addProduct(laptop);
        ClothingProduct jeans = new ClothingProduct(productManager.getNextProductId(),"Jeans", 29.99,  "Large");
        productManager.addProduct(jeans);
        BookProduct cookbook = new BookProduct(productManager.getNextProductId(),"Cookbook", 17.99, "hatem", 15);
        productManager.addProduct(cookbook);
        ClothingProduct shirt = new ClothingProduct(productManager.getNextProductId(), "T-Shirt", 25.0, "M");
        productManager.addProduct(shirt);
        BookProduct novel = new BookProduct(productManager.getNextProductId(), "La chèvre de Monsieur Seguin", 7.0, "Alphonse Daudet", 15);
        productManager.addProduct(novel);
        FoodProduct chocolate = new FoodProduct(productManager.getNextProductId(), "Gaufrette Choco Tom", 1.6, "2023-12-31");
        productManager.addProduct(chocolate);
        ElectronicsProduct phone = new ElectronicsProduct(productManager.getNextProductId(), "Phone", 700.0, "Redmi");
        productManager.addProduct(phone);
        inventory.addProduct(laptop, 20);
        inventory.addProduct(shirt, 20);
        inventory.addProduct(novel, 20);
        inventory.addProduct(phone, 20);
        inventory.addProduct(cookbook, 20);
        inventory.addProduct(jeans, 20);
        inventory.addProduct(camera, 20);
        inventory.addProduct(chocolate, 20);
        //----------------------------------------------------------------------------------------------
        while (true) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    // Login
                    User loggedInUser = login(loginManager);
                    if (loggedInUser != null) {
                        System.out.println("Login successful. Welcome, " + loggedInUser.getUsername() + "!");
                        // Perform actions based on the user role (admin/customer)
                        processUser(loggedInUser,loginManager,userDatabase,productManager,inventory,orders);
                    } else {
                        System.out.println("Login failed. Please check your username and password.");
                    }
                    break;
                case 2:
                    // Register
                    register(userDatabase);
                    break;
                case 3:
                    // Exit
                    System.out.println("Exiting the Website. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }
    private static User login(LoginManager l ) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        boolean x=l.login(username,password);
        if (x==true)
            return l.getUserDatabase().getuser(username);
        else
            return null;
    }
    private static void register(UserDatabase userDatabase) {
        System.out.println("Registration:");
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user= new User(username,password,"customer");
        userDatabase.addUser(user);
    }
    public static int getIntInput(String prompt) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(ANSI_YELLOW+prompt+ANSI_RESET);
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return input;
    }
    private static void printMainMenu() {
        System.out.println(ANSI_CYAN + "Menu:" + ANSI_RESET);
        System.out.println("1."+ANSI_GREEN+" Log in"+ANSI_RESET);
        System.out.println("2."+ANSI_GREEN+" Register"+ANSI_RESET);
        System.out.println("3."+ANSI_RED+" Exit"+ANSI_RESET);
    }
    private static void processUser(User user,LoginManager loginManager,UserDatabase userDatabase,ProductManager productManager,Inventory inventory,Orders orders) {
        // Based on the user's role, perform actions
        if (user.getRole().equals("admin")) {
            processAdminActions(user,userDatabase,productManager,inventory,orders);
        } else {
            processCustomerActions(user,userDatabase,productManager,inventory,orders);

        }
    }
    private static void printCustomerMenu() {
        System.out.println(ANSI_CYAN + "Customer Menu:" + ANSI_RESET);
        System.out.printf(
                "1. %s%-15s%s | 2. %s%-15s%s | 3. %s%-15s%s%n",
                ANSI_BLUE, "View Products", ANSI_RESET,
                ANSI_BLUE, "Search Products", ANSI_RESET,
                ANSI_BLUE, "Add to Cart", ANSI_RESET
        );
        System.out.printf(
                "4. %s%-15s%s | 5. %s%-15s%s | 6. %s%-15s%s%n",
                ANSI_BLUE, "View Cart", ANSI_RESET,
                ANSI_BLUE, "Checkout", ANSI_RESET,
                ANSI_BLUE, "Rate Product", ANSI_RESET
        );
        System.out.printf("0. %s%-15s%s%n", ANSI_RED, "Log out", ANSI_RESET);
    }
    private static void processCustomerActions(User user,UserDatabase userDatabase,ProductManager productManager,Inventory inventory,Orders orders) {
        ShoppingCart shoppingCart = new ShoppingCart(user);

        while (true) {
            printCustomerMenu();
            int customerChoice = getIntInput("Enter your choice : ");

            switch (customerChoice) {
                case 1:
                    // View Products
                    productManager.displayAllProducts();
                    break;
                case 2:
                    // Search Products
                    System.out.println(ANSI_CYAN+"Search Products:"+ANSI_RESET);
                    System.out.println("1."+ANSI_BLUE+" Search by Keyword"+ANSI_RESET);
                    System.out.println("2."+ANSI_BLUE+" Search by Price Range"+ANSI_RESET);
                    System.out.println("3."+ANSI_BLUE+" Search by Category"+ANSI_RESET);
                    System.out.println("0."+ANSI_GREEN+" Back to Customer MenU"+ANSI_RESET);
                    ProductSearch productSearch=new ProductSearch();
                    int searchChoice = getIntInput("Enter your choice: ");
                    switch (searchChoice) {
                        case 1:
                            // Search by Keyword
                            System.out.println("Enter keyword: ");
                            String keyword = scanner.nextLine();
                            List<Product> l= productSearch.searchByKeyword(productManager.getProducts(),keyword);
                            System.out.println("Filter Results for keyword : "+keyword);
                            for (Product product : l) {
                                System.out.println(product.toString());
                            }
                            break;
                        case 2:
                            // Search by Price Range
                            double minPrice = getDoubleInput("Enter minimum price: ");
                            double maxPrice = getDoubleInput("Enter maximum price: ");
                            List<Product> l2=productSearch.filterByPriceRange(productManager.getProducts(),minPrice,maxPrice);
                            System.out.println("Products filtered by price :");
                            for (Product product : l2) {
                                System.out.println(product.toString());
                            }
                            break;
                        case 3:
                            // Search by Category
                            System.out.println("Enter category: ");
                            String category = scanner.nextLine();
                            List<Product> l3=productSearch.filterByCategory(productManager.getProducts(),category);
                            System.out.println("Products filtered by category : "+category);
                            for (Product product : l3) {
                                System.out.println(product.toString());
                            }
                            break;
                        case 0:
                            System.out.println("Returning to Customer Menu...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 3:
                    // Add to Cart
                    // Ask for product ID
                    int productId = getIntInput("Enter the Product ID to add to the cart: ");
                    // Ask for quantity
                    int quantity = getIntInput("Enter the quantity: ");
                    Product product=productManager.getProductById(productId);
                    if (product != null) {
                        if (inventory.isInStock(product,quantity)) {
                            shoppingCart.addItem(product, quantity);
                            System.out.println("Product added to the cart.");
                        }
                        else
                            System.out.println("We don't have the quantity you need in stock");
                    } else {
                        System.out.println("Product not found. Please enter a valid Product ID.");
                    }

                    break;
                case 4:
                    // View Cart
                    shoppingCart.displayCart();
                    break;
                case 5:
                    ShippingManager shippingManager=new ShippingManager();
                    // Checkout
                    System.out.println("Checkout:");

                    // Ask for shipping method
                    String shippingMethod = getValidShippingMethodInput();
                    shippingManager.selectShippingMethod(shippingMethod);
                    shippingManager.displayShippingInfo(shippingMethod, shoppingCart);
                    boolean proceedWithOrder = getYesNoInput("Proceed with the order? (yes/no): ");
                    if (proceedWithOrder) {

                        // Create the order
                        Order newOrder = shoppingCart.checkout(shippingMethod,shippingManager);
                        if (newOrder != null) {
                            for (CartItem i : newOrder.getOrderedItems()) {
                                Product p= i.getProduct();
                                int quant=i.getQuantity();
                                inventory.reduceProductQuantity(p,quant);

                            }
                            String paymentMethod = getPaymentMethodInput();
                            PaymentProcessor paymentProcessor=new PaymentProcessor();
                            if (paymentMethod.equals("paypal")) {
                                boolean p=false;
                                while(!p) {
                                    String mail = getStringInput("Enter E-mail address");
                                    p=paymentProcessor.processPayPalPayment(mail, newOrder.getTotalCartPrice());
                                }
                            }
                            else{
                                boolean t=false;
                                while(!t) {
                                    String card = getStringInput("Enter card number");
                                    t=paymentProcessor.processCreditCardPayment(card, newOrder.getTotalCartPrice());
                                }

                            }
                            // Save the order
                            orders.addOrder(newOrder);
                            System.out.println("Payment Successful");
                            // displayOrderConfirmation(newOrder);
                        }
                    } else {
                        System.out.println("Order canceled.");
                    }

                    break;
                case 6:
                    // Rate Product
                    System.out.println("Rating a product...");

                    int productIdForRating;
                    Product prod;

                    // Loop until a valid product ID is entered
                    while (true) {
                        productIdForRating = getIntInput("Enter the Product ID to rate: ");
                        prod = productManager.getProductById(productIdForRating);

                        if (prod != null) {
                            break;  // Exit the loop if a valid product ID is entered
                        }

                        System.out.println("Product not found. Please enter a valid Product ID.");
                    }

                    // Loop until a valid rating is entered
                    int rating;
                    while (true) {
                        rating = getIntInput("Enter the rating (1-5): ");

                        if (rating >= 1 && rating <= 5) {
                            break;  // Exit the loop if a valid rating is entered
                        }

                        System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
                    }

                    // Ask for optional comment
                    System.out.print("Enter an optional comment (or press Enter to skip): ");
                    String comment = scanner.nextLine();
                    Review review = new Review(user.getUsername(), rating, comment);
                    prod.addReview(review);
                    break;
                case 0:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
    }
    public static double getDoubleInput(String prompt) {
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(ANSI_YELLOW+prompt+ANSI_RESET);
                input = Double.parseDouble(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return input;
    }
    public static String getStringInput(String prompt) {
        System.out.print(ANSI_YELLOW+prompt+ANSI_RESET);
        return scanner.nextLine();
    }
    private static String getValidShippingMethodInput() {
        while (true) {
            System.out.print("Enter shipping method (Standard/Express/Overnight): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("standard") || input.equals("express") || input.equals("overnight")) {
                return input;
            } else {
                System.out.println("Invalid shipping method. Please enter Standard, Express, or Overnight.");
            }
        }
    }
    private static boolean getYesNoInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
    private static String getPaymentMethodInput() {
        while (true) {
            System.out.print("Enter payment method (PayPal/Credit Card): ");
            String paymentMethod = scanner.nextLine().toLowerCase();

            if (paymentMethod.equals("paypal") || paymentMethod.equals("credit card")) {
                return paymentMethod;
            } else {
                System.out.println("Invalid payment method. Please enter PayPal or Credit Card.");
            }
        }
    }
    private static void processAdminActions(User user,UserDatabase userDatabase,ProductManager productManager,Inventory inventory,Orders orders) {
        boolean isAdmin = chooseUserRole();

        while (true) {
            if (isAdmin) {
                // Admin Menu
                while(true) {
                    printAdminMenu();
                    int adminChoice = getIntInput("Enter your choice:");

                    switch (adminChoice) {
                        case 1:
                            addNewProduct(productManager, inventory);
                            break;

                        case 2:
                            int productIdForUpdate;
                            Product prod;
                            while (true) {
                                productIdForUpdate = getIntInput("Enter the Product ID to Update: ");
                                prod = productManager.getProductById(productIdForUpdate);

                                if (prod != null) {
                                    productManager.updateProduct(productIdForUpdate, inventory);
                                    break;
                                }

                                System.out.println("Product not found. Please enter a valid Product ID.");
                            }

                            break;

                        case 3:
                            int productIdtodelete;
                            productIdtodelete = getIntInput("Enter the Product ID to Delete: ");
                            productManager.deleteProduct(productIdtodelete);

                            break;

                        case 4:
                            System.out.println("-------------------------------------");
                            inventory.displayInventory();
                            System.out.println("-------------------------------------");
                            break;
                        case 5:
                            String usernameToDelete =getStringInput("Enter the username to delete: ");
                            userDatabase.deleteUserByUsername(usernameToDelete);
                            break;
                        case 6:
                            userDatabase.showAllUsersInformation();
                            break;
                        case 0:
                            // Log out
                            System.out.println("Logging out as admin. Goodbye!");
                            return;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            } else {
                // Customer Menu (You can implement this part based on the existing customer menu logic)
                processCustomerActions(user,userDatabase,productManager,inventory,orders);
            }

            // After completing admin or customer actions, ask if the admin wants to switch roles
            boolean switchRoles = getYesNoInput("Do you want to switch roles? (yes/no): ");
            if (switchRoles) {
                isAdmin = !isAdmin; // Toggle between admin and customer roles
            } else {
                System.out.println("Logging out. Goodbye!");
                return;
            }
        }
    }

    private static boolean chooseUserRole() {
        System.out.print("Do you want to act as an admin or a customer? (admin/customer): ");
        String roleChoice = scanner.nextLine().toLowerCase();

        if (roleChoice.equals("admin")) {
            return true;
        } else if (roleChoice.equals("customer")) {
            return false;
        } else {
            System.out.println("Invalid choice. Defaulting to admin role.");
            return true; // Default to admin role if an invalid choice is entered
        }
    }
    private static void printAdminMenu() {
        // Print the admin menu options
        System.out.println(ANSI_CYAN + "Admin Menu:" + ANSI_RESET);
        System.out.printf(
                "1. %s%-15s%s | 2. %s%-15s%s | 3. %s%-15s%s%n",
                ANSI_BLUE, "Add Product", ANSI_RESET,
                ANSI_BLUE, "Update Product", ANSI_RESET,
                ANSI_BLUE, "Remove Product", ANSI_RESET
        );
        System.out.printf(
                "4. %s%-15s%s | 5. %s%-15s%s | 6. %s%-15s%s%n",
                ANSI_BLUE, "View Inventory", ANSI_RESET,
                ANSI_BLUE, "Delete User", ANSI_RESET,
                ANSI_BLUE, "Show All Users", ANSI_RESET
        );
        System.out.printf("0. %s%-15s%s%n", ANSI_RED, "Log out", ANSI_RESET);
    }
    private static void addNewProduct(ProductManager productManager,Inventory inventory) {
        // Ask for product details
        String productName = getStringInput("Enter the product name: ");
        double price = getDoubleInput("Enter the product price: ");
        int quantity = getIntInput("Enter the product quantity: ");
        String category = getStringInput("Enter the product category (electronics/food/clothing/book): ");

        // Create a new product based on the category
        Product newProduct;
        switch (category.toLowerCase()) {
            case "electronics":
                String electronicsBrand = getStringInput("Enter the brand of the electronics: ");
                newProduct = new ElectronicsProduct(productManager.getNextProductId(), productName, price, electronicsBrand);
                break;
            case "food":
                String expirationDate = getStringInput("Enter the expiration date of the food (e.g., YYYY-MM-DD): ");
                newProduct = new FoodProduct(productManager.getNextProductId(), productName, price,  expirationDate);
                break;
            case "clothing":
                String size = getStringInput("Enter the size of the clothing: ");
                newProduct = new ClothingProduct(productManager.getNextProductId(), productName, price, size);
                break;
            case "book":
                String author = getStringInput("Enter the author of the book: ");
                int pagecount=getIntInput("Enter the number of pages: ");
                newProduct = new BookProduct(productManager.getNextProductId(), productName, price, author,pagecount);
                break;
            default:
                System.out.println("Invalid product category. Product not added.");
                return;
        }

        // Add the product to the product manager
        productManager.addProduct(newProduct);
        inventory.addProduct(newProduct,quantity);

        System.out.println("Product added successfully.");
    }
}



