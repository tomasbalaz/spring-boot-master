package sk.balaz.springbootmaster.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {


    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepo;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepo);
    }

    @AfterEach
    void tearDown() {
        customerRepo.deleteAll();
    }

    @Test
    void getCustomers() {

        //given
        Customer tomas = new Customer(
                1L,
                "tomas",
                "password",
                "tomas@gamil.com"
        );

        Customer jane = new Customer(
                2L,
                "jane",
                "password",
                "jane@gamil.com"
        );

        customerRepo.saveAll(List.of(tomas, jane));

        //when
        List<Customer> customers = customerService.getCustomers();

        //then
        assertEquals(2, customers.size());

    }

    @Test
    void getCustomer() {

        //given
        Customer tomas = new Customer(
                1L,
                "tomas",
                "password",
                "tomas@gamil.com"
        );

        customerRepo.save(tomas);

        //when
        Customer customer = customerService.getCustomer(1L);

        //then
        assertEquals(1L, customer.getId());
        assertEquals("tomas", customer.getName());
        assertEquals("password", customer.getPassword());
        assertEquals("tomas@gamil.com", customer.getEmail());

    }
}