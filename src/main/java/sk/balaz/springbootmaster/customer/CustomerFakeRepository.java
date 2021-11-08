package sk.balaz.springbootmaster.customer;

import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        // 1. solution not recommended
//        return Arrays.asList(
//                new Customer(1L, "James Bond"),
//                new Customer(2L, "Jamila Conc")
//                );

        // 2. solution supported from Java 9
        return List.of(
                new Customer(1L, "James Bond", "123", "email@gmmail.com"),
                new Customer(2L, "Jamila Conc", "password123", "email@gmmail.com")
        );
    }
}
