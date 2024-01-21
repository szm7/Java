import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

class Product {

    int productId;
    String productName;

    public Product(int productId, String productName) {

        this.productId = productId;
        this.productName = productName;

    }

    public int getPid() {
        return productId;
    }

    public String getPname() {
        return productName;
    }

}

class Customer {
    public int customerId;
    public String customerName;
    public int customerPincode;

    public Customer(int customerId, String customerName, int customerPincode) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPincode = customerPincode;
    }

    public int returncustomerId() {
        return customerId;
    }

    public String returncustomerName() {
        return customerName;
    }

    public int returnPincode() {
        return customerPincode;
    }
}

class Order {

    public int orderId;
    public Customer customer;
    public ArrayList<Product> products;

    public Order(int orderId, Customer customer) {

        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();

    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}

public class AmazonCRM {

    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Product> products;
    private HashMap<Integer, Customer> customerMap;
    private HashMap<Integer, Product> productMap;
    private HashMap<Customer, HashSet<Product>> customerproductMap;
    private TreeSet<Customer> sortedCustomers;

    public AmazonCRM() {

        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        customerMap = new HashMap<>();
        productMap = new HashMap<>();
        customerproductMap = new HashMap<>();
        sortedCustomers = new TreeSet<>((c1, c2) -> c1.returncustomerName().compareTo(c2.returncustomerName())); // To
                                                                                                                 // maintain
                                                                                                                 // ordered
                                                                                                                 // collection
                                                                                                                 // of
                                                                                                                 // customers

    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerMap.put(customer.returncustomerId(), customer);
        sortedCustomers.add(customer);
    }

    public void addProduct(Product product) {

        products.add(product);
        productMap.put(product.getPid(), product);

    }

    public void placeOrder(Order order) {
        orders.add(order);
        Customer customer = order.customer;
        HashSet<Product> customerProducts = customerproductMap.getOrDefault(customer, new HashSet<>());
        customerProducts.addAll(order.getProducts());
        customerproductMap.put(customer, customerProducts);
    }

    public Customer findCustomerById(Integer customerId) {
        return customerMap.get(customerId);
    }

    public Product findProductById(Integer productId) {
        return productMap.get(productId);
    }

    public HashSet<Product> getProductsForCustomer(Customer customer) {

        return customerproductMap.getOrDefault(customer, new HashSet<>());

    }

    public TreeSet<Customer> getSortedCustomers() {
        return sortedCustomers;
    }

    public static void main(String[] args) {

        AmazonCRM acrm = new AmazonCRM();

        Customer customer1 = new Customer(234, "Sanin", 560069);
        Customer customer2 = new Customer(235, "Rahul", 560027);

        Product product1 = new Product(777, "Apple iphone");
        Product product2 = new Product(888, "Nokia N73");

        Order order1 = new Order(144, customer1);

        order1.addProducts(product2);

        acrm.addCustomer(customer1);
        acrm.addCustomer(customer2);
        acrm.addProduct(product2);
        acrm.addProduct(product1);
        acrm.placeOrder(order1);

        Customer retrievedCustomer = acrm.findCustomerById(234);
        if (retrievedCustomer != null) {

            System.out.println("");
            System.out.println("Enhancing Amazon's CRM Infra");
            System.out.println("----------------------------");
            System.out.println("");

            System.out.println("Retrieved Customer: " + retrievedCustomer.returncustomerName());
        }

        HashSet<Product> prodforCust1 = acrm.getProductsForCustomer(customer1);
        System.out.println("Products for customer 1: ");
        for (Product product : prodforCust1) {
            System.out.println(product.getPname());
        }

        TreeSet<Customer> sortedCustomers = acrm.getSortedCustomers();
        System.out.println("Sorted Customers");
        for (Customer sortedCustomer : sortedCustomers) {
            System.out.println(sortedCustomer.returncustomerName());
        }

    }

}