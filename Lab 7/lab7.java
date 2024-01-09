import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// Customer class
class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Other getters and setters for customer details
}

// Product class
class Product {
    private String productId;
    private String name;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    // Other getters and setters for product details
}

// Order class
class Order {
    private String orderId;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(String orderId, Customer customer, ArrayList<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // Other getters and setters for order details
}

// AmazonCRMSystem class
class AmazonCRMSystem {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private HashSet<Product> uniqueProducts = new HashSet<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
        uniqueProducts.add(product);
    }

    public void placeOrder(Order order) {
        orders.add(order);
        // Assuming you want to add products from the order to the uniqueProducts
        // HashSet
        uniqueProducts.addAll(order.getProducts());
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add User");
        System.out.println("2. Update User details");
        System.out.println("3. Add Prod");
        System.out.println("4. Update Prod");
        System.out.println("5. Track Order");
        System.out.println("6. View Order History");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void performOperation(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter user ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter user name: ");
                String userName = scanner.nextLine();
                addCustomer(new Customer(userId, userName));
                System.out.println("User added successfully!");
                break;
            case 2:
                System.out.print("Enter user ID to update: ");
                userId = scanner.nextLine();
                System.out.print("Enter user name: ");
                userName = scanner.nextLine();
                addCustomer(new Customer(userId, userName));
                System.out.println("User added successfully!");
                break;
            case 3:
                System.out.print("Enter product ID: ");
                String prodId = scanner.nextLine();
                System.out.print("Enter product name: ");
                String prodName = scanner.nextLine();
                addProduct(new Product(prodId, prodName));
                System.out.println("Product added successfully!");
                break;
            case 4:
                // Implement update product details
                break;
            case 5:
                // Implement order tracking
                break;
            case 6:
                // Implement viewing order history
                break;
            case 0:
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    public static void main(String[] args) {
        AmazonCRMSystem amazonCRMSystem = new AmazonCRMSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            amazonCRMSystem.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            amazonCRMSystem.performOperation(choice);
        }
    }
}