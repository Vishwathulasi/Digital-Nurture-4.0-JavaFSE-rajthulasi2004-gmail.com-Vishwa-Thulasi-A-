package Exercise_11_Implementing_Dependency_Injection;

import java.util.HashMap;
import java.util.Map;
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface CustomerRepository {
    Customer findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerData = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerData.put("101", new Customer("101", "Vishwa Thulasi"));
        customerData.put("102", new Customer("102", "Arun Kumar"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerData.get(id);
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomerDetails(String id) {
        Customer customer = repository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }
}

public class Exercise11 {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.displayCustomerDetails("101");
        System.out.println();
        service.displayCustomerDetails("999");  // Non-existent
    }
}
