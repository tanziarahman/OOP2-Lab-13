import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightCustomerManager {
    private final Map<String, List<Customer>> flightCustomers = new HashMap<>();

    public void registerCustomer(String flightNumber, Customer customer) {
        flightCustomers.computeIfAbsent(flightNumber, k -> new ArrayList<>()).add(customer);
    }

    public boolean isCustomerRegistered(String flightNumber, Customer customer) {
        return flightCustomers.getOrDefault(flightNumber, new ArrayList<>())
                .stream()
                .anyMatch(c -> c.getUserID().equals(customer.getUserID()));
    }

    public List<Customer> getCustomers(String flightNumber) {
        return flightCustomers.getOrDefault(flightNumber, new ArrayList<>());
    }
}
