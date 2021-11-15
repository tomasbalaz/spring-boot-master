package sk.balaz.springbootmaster.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.balaz.springbootmaster.exception.NotFoundException;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {

        LOGGER.info("getCustomers was called");

        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {

                            NotFoundException notFoundException = new NotFoundException(
                                    "customer with id '" + id + "' not found");

                            LOGGER.error(notFoundException.toString());
                            LOGGER.error("error in getCustomer {}", id);
                            LOGGER.error("error in getCustomer {}", id, notFoundException);

                            return notFoundException;
                        });

    }
}
