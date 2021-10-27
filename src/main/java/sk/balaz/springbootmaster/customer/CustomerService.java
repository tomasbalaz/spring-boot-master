package sk.balaz.springbootmaster.customer;

public class CustomerService {

    Customer getCustomer() {
        return new Customer(1L, "James Bond");
    }
}
