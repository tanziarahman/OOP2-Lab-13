import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerService {
    Customer customer;

    private List<Flight> flightsRegisteredByUser;
    private List<Integer> numOfTicketsBookedByUser;
    public static final List<Customer> customerCollection = User.getCustomersCollection();

    public void addNewCustomer(Customer customer) {
        customerCollection.add(customer);
    }


    public CustomerService(Customer customer) {
        this.customer = customer;
        this.flightsRegisteredByUser = new ArrayList<>();
        this.numOfTicketsBookedByUser = new ArrayList<>();
    }

    /**
     * Searches for customer with the given ID and displays the customers' data if
     * found.
     *
     * @param ID of the searching/required customer
     */
    public void searchUser(String ID) {
        Customer customer = findCustomerByID(ID); // Use the extracted method

        if (customer != null) {
            System.out.printf("%-50sCustomer Found...!!! Here is the Full Record...!!!\n\n\n", " ");
            displayHeader();
            System.out.println(customer.toString(1));
            System.out.printf(
                    "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                    "");
        } else {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }

    public void editUserInfo(String ID,List<String> details) {
        Customer customer = findCustomerByID(ID);

        if (customer != null) {
            customer.setName(details.get(0));
            customer.setEmail(details.get(1));
            customer.setPhone(details.get(2));
            customer.setAddress(details.get(3));
            customer.setAge(Integer.parseInt(details.get(4)));
            displayCustomersData(false);
        } else {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }
    private Customer findCustomerByID(String ID) {
        for (Customer c : customerCollection) {
            if (ID.equals(c.getUserID())) {
                return c;  // Return customer if found
            }
        }
        return null;  // Return null if not found
    }

    public void deleteUser(String ID) {
        Customer customer = findCustomerByID(ID); // Use extracted method

        if (customer != null) {
            customerCollection.remove(customer); // Remove customer directly
            System.out.printf("\n%-50sPrinting all Customer's Data after deleting Customer with the ID %s.....!!!!\n",
                    "", ID);
            displayCustomersData(false);
        } else {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }

    /**
     * Shows the customers' data in formatted way.
     *
     * @param showHeader to check if we want to print ascii art for the customers'
     *                   data.
     */
    public void displayCustomersData(boolean showHeader) {
        displayHeader();
        Iterator<Customer> iterator = customerCollection.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Customer c = iterator.next();
            System.out.println(c.toString(i));
            System.out.printf(
                    "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                    "");
        }
    }

    /**
     * Shows the header for printing customers data
     */
    void displayHeader() {
        System.out.println();
        System.out.printf(
                "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                "");
        System.out.printf(
                "%10s| SerialNum  |   UserID   | Passenger Names                  | Age     | EmailID\t\t       | Home Address\t\t\t     | Phone Number\t       |%n",
                "");
        System.out.printf(
                "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                "");
        System.out.println();

    }
}
