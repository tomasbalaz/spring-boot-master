package sk.balaz.springbootmaster.customer;

import java.util.List;

public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real DB

        // 1. solution supported before Java 9
        //return Collections.emptyList();

        // 2. solution supported before Java 9
//        return Collections.singletonList(
//                new Customer(1L, "TODO Implement real DB")
//        );

        // 3. solution supported after Java 9
        return List.of(
                new Customer(1L, "TODO Implement real DB", "TODO")
        );
    }
}
