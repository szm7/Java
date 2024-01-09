import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Ama {
    // ArrayList<Customer> customerList = new ArrayList<>();
    // ArrayList<Product> productList = new ArrayList<>();
    // ArrayList<Order> orderList = new ArrayList<>();
    private static final HashMap<String, Customer> customerMap = new HashMap<>();
    HashMap<String, Product> productMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n Menu :");
            System.out.println("1. Add User");
            System.out.println("2. All Customers");
            System.out.println("3. Retrieve Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    retrieveContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book. Goodbye!");

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice < 5);
    }

    static void addUser() {
        System.out.print("Enter Username : ");
        String usName = scanner.nextLine();
        System.out.print("View Customers : ");
        String Name = scanner.nextLine();
        System.out.print("Enter Mobile Number : ");
        String ph = scanner.nextLine();
        Customer cs = new Customer(Name, ph);
        customerMap.put(usName, cs);
        System.out.println("User added successfully!");
    }

    private static void viewUser() {
        System.out.println("--------------------");
        if (customerMap.isEmpty()) {
            System.out.println("customer details empty");
        } else {
            for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
                

                System.out.println("User Name: " + entry.getKey());
                System.out.println("Customer Name : " + entry.getValue());
                

            }
            System.out.println("--------------------");
        }

    }

    static void retrieveContact() {

    }

    static void displayContacts() {

    }
}

class Customer {
    String name;
    String phNo;

    public Customer(String name, String phNo) {
        this.name = name;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", name='" + name + '\'' +
                ", phone='" + phNo + '\'' +
                '}';
    }

}

class Product {

    String productName;

    public Product(String productName) {

        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", productName='" + productName + '\'' +
                '}';
    }

}

class Order {
    String orderId;
    Customer customer;
    ArrayList<Product> products;

    public Order(String orderId, Customer customer, ArrayList<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + customer + '\'' +
                ", products='" + products + '\'' +
                '}';
    }
}
