package Exercise11;
import java.util.*;

interface CustomerRepository {
    Customer findCustomerById(String id);
}

class Customer {
    String id;
    String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + "]";
    }
}

class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Sample data
        database.put("C101", new Customer("C101", "Alice"));
        database.put("C102", new Customer("C102", "Bob"));
    }

    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}

class CustomerService {
    CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(String id) {
        Customer customer = repository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Found: " + customer);
        } else {
            System.out.println("Customer not found for ID: " + id);
        }
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        // Use service to retrieve customer
        service.displayCustomer("C101");
        service.displayCustomer("C999");
    }
}
